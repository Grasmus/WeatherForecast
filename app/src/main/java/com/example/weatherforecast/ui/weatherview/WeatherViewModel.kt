package com.example.weatherforecast.ui.weatherview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.weatherforecast.domain.entities.WeatherResponseEntity
import com.example.weatherforecast.domain.entities.weathermodules.WeatherCondition
import com.example.weatherforecast.domain.entities.weathermodules.WeatherCurrent
import com.example.weatherforecast.domain.entities.weathermodules.WeatherLocation
import com.example.weatherforecast.domain.usecases.GetWeather
import kotlinx.coroutines.launch

class WeatherViewModel(getWeather: GetWeather, city: String) : ViewModel() {

    private val weatherData = MutableLiveData(
        WeatherResponseEntity(
        WeatherLocation(),
        WeatherCurrent(WeatherCondition())
    ))

    init {
        getWeather(::updateWeather, city)
    }

    val cityName: LiveData<String> = weatherData.map { weather ->
        weather.location.name
    }

    val region: LiveData<String> = weatherData.map { weather ->
        weather.location.region
    }

    val country: LiveData<String> = weatherData.map { weather ->
        weather.location.country
    }

    val localTime: LiveData<String> = weatherData.map { weather ->
        weather.location.localtime
    }

    val tempC: LiveData<String> = weatherData.map { weather ->
        "Temperature(°C): " + weather.current.temp_c.toString() + "°C"
    }

    val tempF: LiveData<String> = weatherData.map { weather ->
        "Temperature(°F): " + weather.current.temp_f.toString() + "°F"
    }

    val condition: LiveData<String> = weatherData.map { weather ->
        weather.current.condition.text
    }

    val windMph: LiveData<String> = weatherData.map { weather ->
        "Wind speed in mph: " + weather.current.wind_mph + " mph"
    }

    val windKph: LiveData<String> = weatherData.map { weather ->
        "Wind speed in khp: " + weather.current.wind_kph + " kph"
    }

    val windDir: LiveData<String> = weatherData.map { weather ->
        "Wind direction: " + weather.current.wind_dir
    }

    val humidity: LiveData<String> = weatherData.map { weather ->
        "Humidity: " + weather.current.humidity.toString()
    }

    val feelsLikeC: LiveData<String> = weatherData.map { weather ->
        "Feels like(°C) " + weather.current.feelslike_c.toString() + "°C"
    }

    val feelsLikeF: LiveData<String> = weatherData.map { weather ->
        "Feels like(°F) " + weather.current.feelslike_f.toString() + "°F"
    }

    val uv: LiveData<String> = weatherData.map { weather ->
        "UV: " + weather.current.uv.toString()
    }

    private fun updateWeather(weather: WeatherResponseEntity?) {
        viewModelScope.launch {
            if (weather != null) {
                weatherData.postValue(weather)
            }
        }
    }
}
