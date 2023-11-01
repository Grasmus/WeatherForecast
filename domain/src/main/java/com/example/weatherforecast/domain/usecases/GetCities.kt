package com.example.weatherforecast.domain.usecases

import com.example.weatherforecast.domain.entities.CityEntity
import com.example.weatherforecast.domain.interfaces.ICityRepository

class GetCities(private val cityRepository: ICityRepository) {
    operator fun invoke(): List<CityEntity> = cityRepository.getCities()
}
