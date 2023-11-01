package com.example.weatherforecast.data.sources

import com.example.weatherforecast.data.repositories.IWeatherSource
import com.example.weatherforecast.domain.entities.WeatherResponseEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class WeatherSource(weatherApiUrl: String, private val weatherApiKey: String): IWeatherSource {
    private val retrofit = Retrofit.Builder()
        .baseUrl(weatherApiUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override fun updateCurrentWeatherByCity(updateCallback: (WeatherResponseEntity?) -> Unit, city: String) {
        var weatherResponse: WeatherResponseEntity?

        val apiService = retrofit.create(ApiService::class.java)

        apiService.getCurrentWeather(weatherApiKey, city).enqueue( object:
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
