package com.core.feature_api

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

/**
//   WeatherApp
//   Created by Subham Dhakal on 6/2/23.
 */
interface FeatureApi {
    fun registerGraph(
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    )
}