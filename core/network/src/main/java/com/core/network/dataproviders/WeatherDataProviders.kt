package com.core.network.dataproviders

import com.core.network.ApiService
import javax.inject.Inject

/**
//   WeatherApp
//   Created by Subham Dhakal on 6/1/23.
 */
class WeatherDataProviders @Inject constructor(private val apiService: ApiService) {

    suspend fun getWeatherByLatLong(lat: Double, lon: Double, appId:String) = apiService.getWeatherByLatLong(lat, lon, appId)
    suspend fun getWeatherByCityState(cityState:String,appId:String) = apiService.getWeatherByCityState(cityState, appId)
}