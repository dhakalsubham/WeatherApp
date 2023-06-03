package com.feature.weather.ui.navigation.screen

import android.location.Location
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
import com.core.common.navigation_constants.AppConstants
import com.feature.weather.domain.location.LocationTracker
import com.feature.weather.domain.use_cases.GetWeatherByCityStateUseCase
import com.feature.weather.domain.use_cases.GetWeatherByLatLongUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

/**
//   WeatherApp
//   Created by Subham Dhakal on 6/2/23.
 */
@HiltViewModel
class WeatherSearchViewModel
@Inject constructor(
    private val getWeatherUseCase: GetWeatherByLatLongUseCase,
    private val getWeatherByCityStateUseCase: GetWeatherByCityStateUseCase,
    private val locationTracker: LocationTracker


) : ViewModel() {

    var currentLocation by mutableStateOf<Location?>(null)

    private val _weather = mutableStateOf(WeatherSearchStateHolder())
    val weather: State<WeatherSearchStateHolder> get() = _weather

    private val _query: MutableStateFlow<String> = MutableStateFlow("")
    val query: StateFlow<String> get() = _query

    fun setQuery(s: String) {
        _query.value = s
    }

    init {
        viewModelScope.launch {
            _query.debounce(1000).collectLatest {
                getWeatherByCityState(AppConstants.apiKey,_query.value)
            }
        }
    }

    fun getCurrentLocation() {
        viewModelScope.launch {
            currentLocation = locationTracker.getCurrentLocation()
            getWeatherByLatLong()
        }
    }

    fun getWeatherByLatLong() = viewModelScope.launch {
        currentLocation?.let {
            getWeatherUseCase(it.latitude, it.longitude, AppConstants.apiKey).onEach {
                when (it) {
                    is UiEvent.Loading -> {
                        _weather.value = WeatherSearchStateHolder(isLoading = true)
                    }

                    is UiEvent.Error -> {
                        _weather.value = WeatherSearchStateHolder(error = it.message.toString())
                    }

                    is UiEvent.Success -> {
                        _weather.value = WeatherSearchStateHolder(data = it.data)
                    }

                }
            }.launchIn(viewModelScope)
        }

    }


    fun getWeatherByCityState(appId: String,query:String) = viewModelScope.launch {
        getWeatherByCityStateUseCase(query, appId).onEach {
            when (it) {
                is UiEvent.Loading -> {
                    _weather.value = WeatherSearchStateHolder(isLoading = true)
                }

                is UiEvent.Error -> {
                    _weather.value = WeatherSearchStateHolder(error = it.message.toString())
                }

                is UiEvent.Success -> {
                    _weather.value = WeatherSearchStateHolder(data = it.data)
                }

            }
        }.launchIn(viewModelScope)

    }

}