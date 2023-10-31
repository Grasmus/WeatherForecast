package com.example.weatherforecast.data

import com.example.weatherforecast.domain.CityEntity

class CityRepository(private val citySource: ICitySource) {
    fun getCities(): List<CityEntity> = citySource.getCities()
}

interface ICitySource {
    fun getCities(): List<CityEntity>
}
