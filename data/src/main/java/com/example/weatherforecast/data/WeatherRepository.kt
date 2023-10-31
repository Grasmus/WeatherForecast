package com.example.weatherforecast.data

import com.example.weatherforecast.domain.weathermodules.WeatherResponseEntity

class WeatherRepository(private val weatherSource: IWeatherSource) {
    fun updateCurrentWeatherByCity(updateCallback: (WeatherResponseEntity?) -> Unit,
                                   city: String) = weatherSource.updateCurrentWeatherByCity(updateCallback, city)
}

interface IWeatherSource {
    fun updateCurrentWeatherByCity(updateCallback: (WeatherResponseEntity?) -> Unit, city: String)
}
