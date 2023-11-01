package com.example.weatherforecast.data.repositories

import com.example.weatherforecast.domain.entities.WeatherResponseEntity
import com.example.weatherforecast.domain.usecases.IWeatherRepository

class WeatherRepository(private val weatherSource: IWeatherSource): IWeatherRepository {
    override fun updateCurrentWeatherByCity(updateCallback: (WeatherResponseEntity?) -> Unit,
                                   city: String) = weatherSource.updateCurrentWeatherByCity(updateCallback, city)
}

interface IWeatherSource {
    fun updateCurrentWeatherByCity(updateCallback: (WeatherResponseEntity?) -> Unit, city: String)
}
