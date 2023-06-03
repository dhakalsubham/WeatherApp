package com.feature.weather.data.repo

import com.core.network.dataproviders.WeatherDataProviders
import com.feature.weather.data.mapper.toWeather
import com.feature.weather.domain.model.Weather
import com.feature.weather.domain.repo.WeatherRepository
import javax.inject.Inject

/**
//   WeatherApp
//   Created by Subham Dhakal on 6/1/23.
 */
class WeatherRepoImpl @Inject constructor(private val weatherDataProviders: WeatherDataProviders) : WeatherRepository {
    override suspend fun getWeatherByLatLong(lat: Double, lon: Double, appId: String): Weather {
        return weatherDataProviders.getWeatherByLatLong(lat, lon, appId).toWeather()
    }
    override suspend fun getWeatherByCityState(cityState: String, appId: String): Weather {
        return weatherDataProviders.getWeatherByCityState(cityState, appId).toWeather()
    }

}