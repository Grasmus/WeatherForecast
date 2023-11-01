package com.example.weatherforecast.data.sources

import com.example.weatherforecast.data.repositories.ICitySource
import com.example.weatherforecast.domain.entities.CityEntity

class CitySource: ICitySource {
    override fun getCities(): List<CityEntity> {
        return arrayListOf(
            CityEntity("Kyiv", "Ukraine", 50.45F, 30.523333F),
            CityEntity("Kharkiv", "Ukraine", 49.98081F, 36.25272F),
            CityEntity("Odesa", "Ukraine", 46.482952F, 30.71248F),
            CityEntity("Dnipro", "Ukraine", 48.45F, 34.98333F),
            CityEntity("Donetsk", "Ukraine", 48.023F, 37.80224F),
            CityEntity("Lviv", "Ukraine", 	49.83826F, 24.02324F),
            CityEntity("Sevastopol", "Ukraine", 44.58883F, 33.5224F),
            CityEntity("Luhansk", "Ukraine",  48.56705F, 39.31706F),
            CityEntity("Vinnytsia", "Ukraine", 49.23278F, 28.48097F),
            CityEntity("Simferopol", "Ukraine", 44.95719F, 34.11079F),
            CityEntity("Chernihiv", "Ukraine", 51.50551F, 31.28487F),
            CityEntity("Kherson", "Ukraine", 46.65581F, 32.61780F),
            CityEntity("Poltava", "Ukraine", 49.59373F, 34.54073F),
            CityEntity("Khmelnytskyi", "Ukraine", 49.42161F, 26.99653F),
            CityEntity("Cherkasy", "Ukraine", 49.42854F, 32.06207F),
            CityEntity("Chernivtsi", "Ukraine", 48.29149F, 25.94034F),
            CityEntity("Zhytomyr", "Ukraine", 50.26487F, 28.67669F),
            CityEntity("Sumy", "Ukraine", 50.9216F, 34.80029F),
            CityEntity("Rivne", "Ukraine", 50.62308F, 26.22743F),
            CityEntity("Ivano-Frankivsk", "Ukraine", 48.92150F, 24.70972F),
            CityEntity("Ternopil", "Ukraine", 49.55589F, 25.60556F),
            CityEntity("Lutsk", "Ukraine", 50.75932F, 25.34244F),
            CityEntity("Kerch", "Ukraine", 45.3531F, 36.47429F),
            CityEntity("Kramatorsk", "Ukraine", 48.72305F, 37.55629F),
            CityEntity("Uzhhorod", "Ukraine", 48.61667F, 22.3F),
            CityEntity("Yevpatoriya", "Ukraine", 45.20091F, 33.36655F),
            CityEntity("Kamianets-Podilskyi", "Ukraine", 48.6741F, 26.5729F)
        )
    }
}
