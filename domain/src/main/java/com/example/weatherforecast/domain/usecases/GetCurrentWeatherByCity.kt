package com.example.weatherforecast.domain.usecases

import com.example.weatherforecast.domain.entities.WeatherCurrentResponseEntity
import com.example.weatherforecast.domain.interfaces.IWeatherRepository

class GetCurrentWeatherByCity(private val weatherRepository: IWeatherRepository) {
    operator fun invoke(updateCallback: (weatherResponse: WeatherCurrentResponseEntity?) -> Unit,
                        city: String) {
        weatherRepository.updateCurrentWeatherByCity(updateCallback, city)
    }
}
