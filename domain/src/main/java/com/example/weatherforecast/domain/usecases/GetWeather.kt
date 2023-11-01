package com.example.weatherforecast.domain.usecases

import com.example.weatherforecast.domain.entities.WeatherResponseEntity

class GetWeather(private val weatherRepository: IWeatherRepository) {
    operator fun invoke(updateCallback: (weatherResponse: WeatherResponseEntity?) -> Unit,
                        city: String) {
        weatherRepository.updateCurrentWeatherByCity(updateCallback, city)
    }
}

interface IWeatherRepository {
    fun updateCurrentWeatherByCity(updateCallback: (weatherResponse: WeatherResponseEntity?) -> Unit,
                                   city: String)
}
