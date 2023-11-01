package com.example.weatherforecast.domain.interfaces

import com.example.weatherforecast.domain.entities.CityEntity

interface ICityRepository {
    fun getCities(): List<CityEntity>
}
