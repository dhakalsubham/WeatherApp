package com.feature.weather.domain.location

import android.location.Location

/**
//   WeatherApp
//   Created by Subham Dhakal on 6/2/23.
 */
interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
}