package com.feature.weather.ui.navigation.di

import com.feature.weather.ui.navigation.WeatherApi
import com.feature.weather.ui.navigation.WeatherApiImpl
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
object UiModule {
    @Provides
    fun provideWeatherApi():WeatherApi{
        return  WeatherApiImpl()
    }
}