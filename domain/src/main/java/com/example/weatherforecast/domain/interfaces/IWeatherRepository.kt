package com.example.weatherforecast.domain.interfaces

import com.example.weatherforecast.domain.entities.WeatherCurrentResponseEntity
import com.example.weatherforecast.domain.entities.WeatherForecastResponseEntity

interface IWeatherRepository {
    fun updateCurrentWeatherByCity(updateCallback: (weatherResponse: WeatherCurrentResponseEntity?) -> Unit,
                                   city: String)
    fun updateCurrentWeatherByCoords(updateCallback: (weatherResponse: WeatherCurrentResponseEntity?) -> Unit,
                                     lat: Float,
                                     long: Float)
    fun updateTomorrowWeatherByCoords(updateCallback: (weatherResponse: WeatherForecastResponseEntity?) -> Unit,
                                      lat: Float,
                                      long: Float)
}
