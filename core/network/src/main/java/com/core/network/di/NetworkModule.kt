package com.core.network.di

import com.core.network.ApiService
import com.core.network.dataproviders.WeatherDataProviders
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
//   WeatherApp
//   Created by Subham Dhakal on 6/1/23.
 */
@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    fun providesApiService(): ApiService {
        return Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
    }

    @Provides
    fun provideWeatherDataProvider(apiService: ApiService):WeatherDataProviders{
        return WeatherDataProviders(apiService)
    }
}