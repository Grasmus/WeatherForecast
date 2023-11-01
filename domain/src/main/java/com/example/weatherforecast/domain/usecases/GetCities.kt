package com.example.weatherforecast.domain.usecases

import com.example.weatherforecast.domain.entities.CityEntity

class GetCities(private val cityRepository: ICityRepository) {
    operator fun invoke(): List<CityEntity> = cityRepository.getCities()
}

interface ICityRepository {
    fun getCities(): List<CityEntity>
}
