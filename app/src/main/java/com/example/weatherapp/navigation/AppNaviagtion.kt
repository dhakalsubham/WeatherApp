package com.example.weatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.core.common.navigation_constants.WeatherFeature

/**
//   WeatherApp
//   Created by Subham Dhakal on 6/2/23.
 */

@Composable
fun AppNavGraph(navController: NavHostController, navigationProvider: NavigationProvider) {
    NavHost(navController = navController, startDestination = WeatherFeature.nestedRoute) {
        navigationProvider.weatherApi.registerGraph(
            navController,this
        )
    }
}