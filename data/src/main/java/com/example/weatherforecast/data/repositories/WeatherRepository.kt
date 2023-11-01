package com.example.weatherforecast.data.repositories

import com.example.weatherforecast.domain.entities.WeatherCurrentResponseEntity
import com.example.weatherforecast.domain.entities.WeatherForecastResponseEntity
import com.example.weatherforecast.domain.interfaces.IWeatherRepository

class WeatherRepository(private val weatherSource: IWeatherSource): IWeatherRepository {
    override fun updateCurrentWeatherByCity(updateCallback: (WeatherCurrentResponseEntity?) -> Unit,
                                            city: String) = weatherSource.updateCurrentWeatherByCity(updateCallback, city)

    override fun updateCurrentWeatherByCoords(
        updateCallback: (weatherResponse: WeatherCurrentResponseEntity?) -> Unit,
        lat: Float,
        long: Float
    ) = weatherSource.updateCurrentWeatherByCoords(updateCallback, lat, long)

    override fun updateTomorrowWeatherByCoords(
        updateCallback: (weatherResponse: WeatherForecastResponseEntity?) -> Unit,
        lat: Float,
        long: Float
    ) = weatherSource.updateTomorrowWeatherByCoords(updateCallback, lat, long)
}

interface IWeatherSource {
    fun updateCurrentWeatherByCity(updateCallback: (WeatherCurrentResponseEntity?) -> Unit, city: String)
    fun updateCurrentWeatherByCoords(updateCallback: (WeatherCurrentResponseEntity?) -> Unit, lat: Float, long: Float)
    fun updateTomorrowWeatherByCoords(updateCallback: (WeatherForecastResponseEntity?) -> Unit, lat: Float, long: Float)
}
