package com.example.weatherforecast.usecases

import com.example.weatherforecast.data.WeatherRepository
import com.example.weatherforecast.domain.weathermodules.WeatherResponseEntity

class GetWeather(private val weatherRepository: WeatherRepository) {
    operator fun invoke(updateCallback: (weatherResponse: WeatherResponseEntity?) -> Unit, city: String) {
        weatherRepository.updateCurrentWeatherByCity(updateCallback, city)
    }
}
