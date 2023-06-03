package com.feature.weather.data.di

import android.app.Application
import com.core.network.dataproviders.WeatherDataProviders
import com.feature.weather.data.location.DefaultLocationTracker
import com.feature.weather.data.repo.WeatherRepoImpl
import com.feature.weather.domain.location.LocationTracker
import com.feature.weather.domain.repo.WeatherRepository
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
//   WeatherApp
//   Created by Subham Dhakal on 6/1/23.
 */
@InstallIn(SingletonComponent::class)
@Module
object DataLayerModule {
    @Provides
    fun providesWeatherRepo(weatherDataProviders: WeatherDataProviders):WeatherRepository{
        return WeatherRepoImpl(weatherDataProviders)
    }

    @Provides
    @Singleton
    fun providesFusedLocationProviderClient(
        application: Application
    ): FusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(application)

    @Provides
    @Singleton
    fun providesLocationTracker(
        fusedLocationProviderClient: FusedLocationProviderClient,
        application: Application
    ): LocationTracker = DefaultLocationTracker(
        fusedLocationProviderClient = fusedLocationProviderClient,
        application = application
    )
}