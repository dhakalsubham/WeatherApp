package com.feature.weather.ui.navigation.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.core.common.utils.PreferenceManager
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState

/**
//   WeatherApp
//   Created by Subham Dhakal on 6/2/23.
 */
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun WeatherScreen(viewModel: WeatherSearchViewModel) {
    val result = viewModel.weather.value
    val query = viewModel.query.collectAsState()

    val locationPermissions = rememberMultiplePermissionsState(
        permissions = listOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )
    )

    LaunchedEffect(key1 = locationPermissions.allPermissionsGranted) {
        if (locationPermissions.allPermissionsGranted) {
            viewModel.getCurrentLocation()
        }
    }

    Scaffold(
        topBar = {
            TextField(modifier = Modifier.fillMaxWidth(),
                      value = query.value,
                      onValueChange = {
                          viewModel.setQuery(it)
                      },
                      colors = TextFieldDefaults.textFieldColors(
                          disabledIndicatorColor = Color.Transparent,
                          focusedIndicatorColor = Color.Transparent
                      ),
                      placeholder = { Text(text = "Search Weather...") }, trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                })
        },
    ) {
        Box(
            modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(color = Color.Black)
        ) {
            Column {
                Button(onClick = { viewModel.getWeatherByLatLong() }) {
                    Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center) {
                        Icon(imageVector = Icons.Default.LocationOn, contentDescription = null)
                        Text(text = "Use current location")
                    }
                }
                if (result.isLoading) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }

                }
                if (result.error.isNotBlank()) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = result.error)
                    }
                }
                if (result.data != null) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = result.data.cityName, color = Color.White, fontSize = 18.sp)
                            AsyncImage(
                                modifier = Modifier.size(100.dp),
                                model = result.data.icon,
                                contentDescription = null,
                                contentScale = ContentScale.FillBounds
                            )
                            //I would put these text in strings.xml
                            //I would create reuseable composables for texts
                            Text(text = result.data.temperature+"\u2109", color = Color.White, fontSize = 24.sp)
                            Text(text = result.data.highAndLow, color = Color.White, fontSize = 18.sp)
                            Text(text = "Feels Like: "+result.data.feelsLike+"\u2109", color = Color.White, fontSize = 20.sp)
                            Text(text = "Pressure: "+result.data.pressure, color = Color.White, fontSize = 18.sp)
                            Text(text = "Humidity: "+result.data.humidity, color = Color.White, fontSize = 18.sp)
                            Text(text = "Wind Speed: "+result.data.windSpeed, color = Color.White, fontSize = 18.sp)
                            Text(text = "Visibility: "+result.data.visibility, color = Color.White, fontSize = 18.sp)

                        }
                    }
                }

                AnimatedContent(
                    targetState = locationPermissions.allPermissionsGranted
                ) { areGranted ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        if (!areGranted) {
                            Text(text = "We need location permissions for this application.")
                            Button(
                                onClick = { locationPermissions.launchMultiplePermissionRequest() }
                            ) {
                                Text(text = "Accept")
                            }
                        }
                    }
                }

            }
        }


    }
}


