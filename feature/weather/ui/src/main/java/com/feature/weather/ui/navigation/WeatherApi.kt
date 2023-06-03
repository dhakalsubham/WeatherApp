package com.feature.weather.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.core.feature_api.FeatureApi

/**
//   WeatherApp
//   Created by Subham Dhakal on 6/2/23.
 */
interface WeatherApi:FeatureApi {
}

class WeatherApiImpl:WeatherApi{
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        InternalWeatherFeatureApi.registerGraph(
            navController,navGraphBuilder
        )
    }

}