package com.example.weatherforecast.data.sources

import com.example.weatherforecast.data.repositories.IWeatherSource
import com.example.weatherforecast.domain.entities.WeatherCurrentResponseEntity
import com.example.weatherforecast.domain.entities.WeatherForecastResponseEntity
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

    override fun updateCurrentWeatherByCity(updateCallback: (WeatherCurrentResponseEntity?) -> Unit, city: String) {
        var weatherResponse: WeatherCurrentResponseEntity?
        val apiService = retrofit.create(ApiService::class.java)

        apiService.getCurrentWeatherByCity(weatherApiKey, city).enqueue( object:
            Callback<WeatherCurrentResponseEntity> {
            override fun onResponse(call: Call<WeatherCurrentResponseEntity>, response: Response<WeatherCurrentResponseEntity>) {
                if (response.isSuccessful && response.body() != null) {
                    weatherResponse = response.body()

                    if (weatherResponse != null) {
                        updateCallback(weatherResponse)
                    }
                }
            }

            override fun onFailure(call: Call<WeatherCurrentResponseEntity>, t: Throwable) {
                error("Failed to call api")
            }
        })
    }

    override fun updateCurrentWeatherByCoords(
        updateCallback: (WeatherCurrentResponseEntity?) -> Unit,
        lat: Float,
        long: Float
    ) {
        var weatherResponse: WeatherCurrentResponseEntity?
        val apiService = retrofit.create(ApiService::class.java)
        val coords = "$lat,$long"

        apiService.getCurrentWeatherByCoords(weatherApiKey, coords).enqueue( object:
            Callback<WeatherCurrentResponseEntity> {
            override fun onResponse(call: Call<WeatherCurrentResponseEntity>, response: Response<WeatherCurrentResponseEntity>) {
                if (response.isSuccessful && response.body() != null) {
                    weatherResponse = response.body()

                    if (weatherResponse != null) {
                        updateCallback(weatherResponse)
                    }
                }
            }

            override fun onFailure(call: Call<WeatherCurrentResponseEntity>, t: Throwable) {
                error("Failed to call api")
            }
        })
    }

    override fun updateTomorrowWeatherByCoords(
        updateCallback: (WeatherForecastResponseEntity?) -> Unit,
        lat: Float,
        long: Float
    ) {
        var weatherResponse: WeatherForecastResponseEntity?
        val apiService = retrofit.create(ApiService::class.java)
        val coords = "$lat,$long"

        apiService.getTomorrowWeatherByCoords(weatherApiKey, coords, 2).enqueue( object:
            Callback<WeatherForecastResponseEntity> {
            override fun onResponse(call: Call<WeatherForecastResponseEntity>, response: Response<WeatherForecastResponseEntity>) {
                if (response.isSuccessful && response.body() != null) {
                    weatherResponse = response.body()

                    if (weatherResponse != null) {
                        updateCallback(weatherResponse)
                    }
                }
            }

            override fun onFailure(call: Call<WeatherForecastResponseEntity>, t: Throwable) {
                error("Failed to call api")
            }
        })
    }
}

interface ApiService {
    @GET("current.json")
    fun getCurrentWeatherByCity(@Query("key") key: String,
                                @Query("q") city: String): Call<WeatherCurrentResponseEntity>

    @GET("current.json")
    fun getCurrentWeatherByCoords(@Query("key") key: String,
                                  @Query("q") coords: String): Call<WeatherCurrentResponseEntity>

    @GET("forecast.json")
    fun getTomorrowWeatherByCoords(@Query("key") key: String,
                                   @Query("q") coords: String,
                                   @Query("days") days: Int): Call<WeatherForecastResponseEntity>
}
