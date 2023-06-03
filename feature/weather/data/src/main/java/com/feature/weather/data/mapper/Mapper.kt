package com.feature.weather.data.mapper

import com.core.network.model.WeatherResponse
import com.feature.weather.domain.model.Weather

/**
//   WeatherApp
//   Created by Subham Dhakal on 6/2/23.
 */

fun WeatherResponse.toWeather(): Weather {
    return Weather(
        this.name,
        this.coord.lat,
        this.coord.lon,
        this.weather[0].description,// I would not do this in the real app
        "https://openweathermap.org/img/wn/${this.weather[0].icon}@2x.png",// I would not do this in the real app
        this.main.temp.toInt().toString(),
        "H: "+this.main.temp_max.toInt()+" "+"L: "+this.main.temp_min.toInt(),
        this.main.feels_like.toInt().toString(),
        this.main.pressure,
        this.main.humidity,
        this.visibility,
        this.wind.speed
    )
}