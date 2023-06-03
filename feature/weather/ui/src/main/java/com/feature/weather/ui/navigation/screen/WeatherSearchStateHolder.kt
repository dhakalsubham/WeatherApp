package com.feature.weather.ui.navigation.screen

import com.feature.weather.domain.model.Weather

/**
//   WeatherApp
//   Created by Subham Dhakal on 6/2/23.
 */
data class WeatherSearchStateHolder(
    val isLoading:Boolean = false,
    val data: Weather? = null,
    val error: String = ""
)
