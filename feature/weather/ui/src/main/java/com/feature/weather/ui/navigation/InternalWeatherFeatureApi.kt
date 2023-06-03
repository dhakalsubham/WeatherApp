package com.feature.weather.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.core.common.navigation_constants.WeatherFeature
import com.core.feature_api.FeatureApi
import com.feature.weather.ui.navigation.screen.WeatherScreen
import com.feature.weather.ui.navigation.screen.WeatherSearchViewModel

/**
//   WeatherApp
//   Created by Subham Dhakal on 6/2/23.
 */
internal object InternalWeatherFeatureApi : FeatureApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(startDestination = WeatherFeature.weatherScreenRoute, route = WeatherFeature.nestedRoute) {
            composable(WeatherFeature.weatherScreenRoute) {
                val viewModel = hiltViewModel<WeatherSearchViewModel>()
                WeatherScreen(viewModel = viewModel)
            }
        }
    }
}