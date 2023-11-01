package com.example.weatherforecast.data.sources

import com.example.weatherforecast.data.repositories.ICitySource
import com.example.weatherforecast.domain.entities.CityEntity

class CitySource: ICitySource {
    override fun getCities(): List<CityEntity> {
        return arrayListOf(
            CityEntity("Kyiv", "Ukraine"),
            CityEntity("Kharkiv", "Ukraine"),
            CityEntity("Odesa", "Ukraine"),
            CityEntity("Dnipro", "Ukraine"),
            CityEntity("Donetsk", "Ukraine"),
            CityEntity("Zaporizhzhia", "Ukraine"),
            CityEntity("Lviv", "Ukraine"),
            CityEntity("Kryvyi Rih", "Ukraine"),
            CityEntity("Mykolaiv", "Ukraine"),
            CityEntity("Sevastopol", "Ukraine"),
            CityEntity("Mariupol", "Ukraine"),
            CityEntity("Luhansk", "Ukraine"),
            CityEntity("Vinnytsia", "Ukraine"),
            CityEntity("Makiivka", "Ukraine"),
            CityEntity("Simferopo", "Ukraine"),
            CityEntity("Chernihiv", "Ukraine"),
            CityEntity("Kherson", "Ukraine"),
            CityEntity("Poltava", "Ukraine"),
            CityEntity("Khmelnytskyi", "Ukraine"),
            CityEntity("Cherkasy", "Ukraine"),
            CityEntity("Chernivtsi", "Ukraine"),
            CityEntity("Zhytomyr", "Ukraine"),
            CityEntity("Sumy", "Ukraine"),
            CityEntity("Rivne", "Ukraine"),
            CityEntity("Horlivka", "Ukraine"),
            CityEntity("Ivano-Frankivsk", "Ukraine"),
            CityEntity("Kamianske", "Ukraine"),
            CityEntity("Ternopil", "Ukraine"),
            CityEntity("Kropyvnytskyi", "Ukraine"),
            CityEntity("Kremenchuk", "Ukraine"),
            CityEntity("Lutsk", "Ukraine"),
            CityEntity("Bila Tserkva", "Ukraine"),
            CityEntity("Kerch", "Ukraine"),
            CityEntity("Melitopol", "Ukraine"),
            CityEntity("Kramatorsk", "Ukraine"),
            CityEntity("Uzhhorod", "Ukraine"),
            CityEntity("Brovary", "Ukraine"),
            CityEntity("Yevpatoria", "Ukraine"),
            CityEntity("Berdiansk", "Ukraine"),
            CityEntity("Kamianets-Podilskyi", "Ukraine")
        )
    }
}
