package com.example.weatherforecast.domain.entities

import com.example.weatherforecast.domain.entities.weathermodules.WeatherCurrent
import com.example.weatherforecast.domain.entities.weathermodules.WeatherForecast
import com.example.weatherforecast.domain.entities.weathermodules.WeatherLocation

class WeatherForecastResponseEntity(val location: WeatherLocation,
                                    val current: WeatherCurrent,
                                    val forecast: WeatherForecast)
