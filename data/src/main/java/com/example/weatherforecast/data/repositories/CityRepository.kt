package com.example.weatherforecast.data.repositories

import com.example.weatherforecast.domain.entities.CityEntity
import com.example.weatherforecast.domain.interfaces.ICityRepository

class CityRepository(private val citySource: ICitySource): ICityRepository {
    override fun getCities(): List<CityEntity> = citySource.getCities()
}

interface ICitySource {
    fun getCities(): List<CityEntity>
}
