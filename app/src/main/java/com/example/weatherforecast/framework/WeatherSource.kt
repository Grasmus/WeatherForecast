package com.example.weatherforecast.framework

import com.example.weatherforecast.BuildConfig
import com.example.weatherforecast.data.IWeatherSource
import com.example.weatherforecast.domain.weathermodules.WeatherResponseEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class WeatherSource: IWeatherSource {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.WEATHER_API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override fun updateCurrentWeatherByCity(updateCallback: (WeatherResponseEntity?) -> Unit, city: String) {
        var weatherResponse: WeatherResponseEntity?

        val apiService = retrofit.create(ApiService::class.java)

        apiService.getCurrentWeather(BuildConfig.WEATHER_API_KEY, city).enqueue( object:
            Callback<WeatherResponseEntity> {
            override fun onResponse(call: Call<WeatherResponseEntity>, response: Response<WeatherResponseEntity>) {
                if (response.isSuccessful && response.body() != null) {
                    weatherResponse = response.body()

                    if (weatherResponse != null) {
                        updateCallback(weatherResponse)
                    }
                }
            }

            override fun onFailure(call: Call<WeatherResponseEntity>, t: Throwable) {
                error("Failed to call api")
            }
        })
    }
}

interface ApiService {
    @GET("current.json")
    fun getCurrentWeather(@Query("key") key: String, @Query("q") city: String): Call<WeatherResponseEntity>
}
