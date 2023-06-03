package com.core.common.utils

/**
//   WeatherApp
//   Created by Subham Dhakal on 6/3/23.
 */
import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("WeatherApp", Context.MODE_PRIVATE)

    fun getString(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    fun putString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }
}