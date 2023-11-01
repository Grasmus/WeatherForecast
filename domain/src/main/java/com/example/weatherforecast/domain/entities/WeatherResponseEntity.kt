package com.example.weatherforecast.domain.entities

import com.example.weatherforecast.domain.entities.weathermodules.WeatherCurrent
import com.example.weatherforecast.domain.entities.weathermodules.WeatherLocation

class WeatherResponseEntity(val location: WeatherLocation, val current: WeatherCurrent)
