package com.feature.weather.domain.use_cases

import com.core.common.UiEvent
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
class GetWeatherByCityStateUseCase @Inject constructor(private val weatherRepository: WeatherRepository){
    operator fun invoke(cityState:String ,appId:String) = flow {
        emit(UiEvent.Loading())
        emit(UiEvent.Success(weatherRepository.getWeatherByCityState(cityState, appId)))
    }.catch {
        emit(UiEvent.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}