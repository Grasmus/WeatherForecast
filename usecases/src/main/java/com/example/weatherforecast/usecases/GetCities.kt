package com.example.weatherforecast.usecases

import com.example.weatherforecast.data.CityRepository
import com.example.weatherforecast.domain.CityEntity

class GetCities(private val cityRepository: CityRepository) {
    operator fun invoke(): List<CityEntity> = cityRepository.getCities()
}
