package com.example.weatherforecast.domain.usecases

import com.example.weatherforecast.domain.entities.WeatherForecastResponseEntity
import com.example.weatherforecast.domain.interfaces.IWeatherRepository

class GetTomorrowWeatherByCoords(private val weatherRepository: IWeatherRepository) {
    operator fun invoke(updateCallback: (weatherResponse: WeatherForecastResponseEntity?) -> Unit,
                        lat: Float,
                        long: Float) {
        weatherRepository.updateTomorrowWeatherByCoords(updateCallback, lat, long)
    }
}
