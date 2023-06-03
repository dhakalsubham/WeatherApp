package com.core.common

/**
//   WeatherApp
//   Created by Subham Dhakal on 6/2/23.
 */
sealed class UiEvent<T>(val data: T? = null, val message: String? = null) {
    class Loading<T>() : UiEvent<T>()

    class Success<T>(data: T) : UiEvent<T>(data = data)

    class Error<T>(message: String) : UiEvent<T>(message = message)

}
