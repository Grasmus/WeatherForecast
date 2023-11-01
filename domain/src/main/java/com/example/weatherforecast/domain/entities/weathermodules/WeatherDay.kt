package com.example.weatherforecast.domain.entities.weathermodules

class WeatherDay(val maxtemp_c: Float = 0F,
                 val maxtemp_f: Float = 0F,
                 val mintemp_c: Float = 0F,
                 val mintemp_f: Float = 0F,
                 val avgtemp_c: Float = 0F,
                 val avgtemp_f: Float = 0F,
                 val maxwind_mph: Float = 0F,
                 val maxwind_kph: Float = 0F,
                 val avghumidity: Int = 0,
                 val daily_chance_of_rain: Int = 0,
                 val daily_chance_of_snow: Int = 0,
                 val condition: WeatherCondition = WeatherCondition(),
                 val uv: Float = 0F)
