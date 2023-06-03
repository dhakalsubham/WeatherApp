package com.core.network

import com.core.common.navigation_constants.MeasurementUnit
import com.core.network.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
//   WeatherApp
//   Created by Subham Dhakal on 6/1/23.
 */
interface ApiService {
    @GET("data/2.5/weather")
    suspend fun getWeatherByLatLong(
        @Query("lat") lat:Double,
        @Query("lon") lon: Double,
        @Query("appid") appId: String,
        @Query("units") units:String = MeasurementUnit.FAHRENHEIT.type
    ):WeatherResponse

    @GET("data/2.5/weather")
    suspend fun getWeatherByCityState(
        @Query("q") cityState:String,
        @Query("appid") appId: String,
        @Query("units") units:String = MeasurementUnit.FAHRENHEIT.type
    ):WeatherResponse
}