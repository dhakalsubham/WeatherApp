package com.feature.weather.domain.use_cases

import com.core.common.UiEvent
import com.feature.weather.domain.model.Weather
import com.feature.weather.domain.repo.WeatherRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
//   WeatherApp
//   Created by Subham Dhakal on 6/2/23.
 */
class GetWeatherByLatLongUseCase @Inject constructor(private val weatherRepository: WeatherRepository){
    operator fun invoke(lat: Double, lon: Double ,appId:String) = flow {
        emit(UiEvent.Loading())
        emit(UiEvent.Success(weatherRepository.getWeatherByLatLong(lat, lon, appId)))
    }.catch {
        emit(UiEvent.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}