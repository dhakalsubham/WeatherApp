package com.feature.weather.domain.repo

import com.feature.weather.domain.model.Weather

/**
//   WeatherApp
//   Created by Subham Dhakal on 6/1/23.
 */
interface WeatherRepository {
    suspend fun getWeatherByLatLong(lat: Double, lon: Double, appId: String): Weather
    suspend fun getWeatherByCityState(cityState: String, appId: String): Weather
}