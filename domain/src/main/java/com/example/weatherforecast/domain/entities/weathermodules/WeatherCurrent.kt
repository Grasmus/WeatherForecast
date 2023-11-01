package com.example.weatherforecast.domain.entities.weathermodules

//commented out fields can be added, if needed
class WeatherCurrent(val condition: WeatherCondition,
              //val last_updated_epoch: Int = 0,
              //val last_updated: String = "",
                     val temp_c: Float = 0F,
                     val temp_f: Float = 0F,
              //val is_day: Int = 0,
                     val wind_mph: Float = 0F,
                     val wind_kph: Float = 0F,
              //val wind_degree: Int = 0,
                     val wind_dir: String = "",
              //val pressure_mb: Int = 0,
              //val pressure_in: Float = 0F,
              //val precip_mm: Float = 0F,
              //val precip_in: Float = 0F,
                     val humidity: Int = 0,
              //val cloud: Int = 0,
                     val feelslike_c: Float = 0F,
                     val feelslike_f: Float = 0F,
              //val vis_km: Float = 0F,
              //val vis_miles: Float = 0F,
                     val uv: Float = 0F
              //val gust_mph: Float = 0F,
                     /*val gust_kph: Float = 0F*/)
