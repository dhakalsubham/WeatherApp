package com.feature.weather.domain.model

/**
//   WeatherApp
//   Created by Subham Dhakal on 6/2/23.
 */
data class Weather(
    var cityName: String,
    var lat: Double,
    var long: Double,
    var cloudsDescription: String,
    var icon: String,
    var temperature: String,
    var highAndLow:String,
    var feelsLike: String,
    var pressure: Int,
    var humidity: Int,
    var visibility: Int,
    var windSpeed: Double,
)




