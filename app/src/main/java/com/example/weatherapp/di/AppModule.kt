package com.example.weatherapp.di

import com.example.weatherapp.navigation.NavigationProvider
import com.feature.weather.ui.navigation.WeatherApi
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
object AppModule {
    @Provides
    fun providerNavigationProvider(weatherApi: WeatherApi):NavigationProvider{
        return NavigationProvider(weatherApi)
    }
}