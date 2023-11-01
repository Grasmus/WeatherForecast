package com.example.weatherforecast.domain.usecases

import com.example.weatherforecast.domain.entities.WeatherCurrentResponseEntity
import com.example.weatherforecast.domain.interfaces.IWeatherRepository

class GetCurrentWeatherByCoords(private val weatherRepository: IWeatherRepository) {
    operator fun invoke(updateCallback: (weatherResponse: WeatherCurrentResponseEntity?) -> Unit,
                        lat: Float,
                        long: Float) {
        weatherRepository.updateCurrentWeatherByCoords(updateCallback, lat, long)
    }
}
