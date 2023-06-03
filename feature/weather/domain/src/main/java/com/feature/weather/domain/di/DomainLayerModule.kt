package com.feature.weather.domain.di

import com.feature.weather.domain.repo.WeatherRepository
import com.feature.weather.domain.use_cases.GetWeatherByLatLongUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
//   WeatherApp
//   Created by Subham Dhakal on 6/2/23.
 */
@InstallIn(SingletonComponent::class)
@Module
object DomainLayerModule {
    @Provides
    fun providesGetWeatherUseCase(weatherRepository: WeatherRepository):GetWeatherByLatLongUseCase{
        return GetWeatherByLatLongUseCase(weatherRepository)
    }
}