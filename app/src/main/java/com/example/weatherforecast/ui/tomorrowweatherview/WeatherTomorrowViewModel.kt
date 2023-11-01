package com.example.weatherforecast.ui.tomorrowweatherview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.weatherforecast.domain.entities.WeatherForecastResponseEntity
import com.example.weatherforecast.domain.entities.weathermodules.WeatherCondition
import com.example.weatherforecast.domain.entities.weathermodules.WeatherCurrent
import com.example.weatherforecast.domain.entities.weathermodules.WeatherForecast
import com.example.weatherforecast.domain.entities.weathermodules.WeatherForecastDay
import com.example.weatherforecast.domain.entities.weathermodules.WeatherLocation
import com.example.weatherforecast.domain.usecases.GetTomorrowWeatherByCoords
import kotlinx.coroutines.launch

class WeatherTomorrowViewModel(getWeather: GetTomorrowWeatherByCoords, lat: Float, long: Float) : ViewModel() {
    private val weatherData = MutableLiveData(
        WeatherForecastResponseEntity(
            WeatherLocation(),
            WeatherCurrent(WeatherCondition()),
            WeatherForecast(listOf(WeatherForecastDay(), WeatherForecastDay()))
        )
    )

    init {
        getWeather(::updateWeather, lat, long)
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
        weather.forecast.forecastday[1].date
    }

    val condition: LiveData<String> = weatherData.map { weather ->
        weather.forecast.forecastday[1].day.condition.text
    }

    val maxTempC: LiveData<String> = weatherData.map { weather ->
        "Max temperature(°C): " + weather.forecast.forecastday[1].day.maxtemp_c.toString() + "°C"
    }

    val maxTempF: LiveData<String> = weatherData.map { weather ->
        "Max temperature(°F): " + weather.forecast.forecastday[1].day.maxtemp_f.toString() + "°F"
    }

    val minTempC: LiveData<String> = weatherData.map { weather ->
        "Min temperature(°C): " + weather.forecast.forecastday[1].day.mintemp_c.toString() + "°C"
    }

    val minTempF: LiveData<String> = weatherData.map { weather ->
        "Min temperature(°F): " + weather.forecast.forecastday[1].day.mintemp_f.toString() + "°F"
    }

    val avgTempC: LiveData<String> = weatherData.map { weather ->
        "Average temperature(°C): " + weather.forecast.forecastday[1].day.avgtemp_c.toString() + "°C"
    }

    val avgTempF: LiveData<String> = weatherData.map { weather ->
        "Average temperature(°F): " + weather.forecast.forecastday[1].day.avgtemp_f.toString() + "°F"
    }

    val maxWindKph: LiveData<String> = weatherData.map { weather ->
        "Max wind speed in kph: " + weather.forecast.forecastday[1].day.maxwind_kph.toString() + " kph"
    }

    val maxWindMph: LiveData<String> = weatherData.map { weather ->
        "Max wind speed in mph: " + weather.forecast.forecastday[1].day.maxwind_mph.toString() + " mph"
    }

    val avgHumidity: LiveData<String> = weatherData.map { weather ->
        "Average humidity: " + weather.forecast.forecastday[1].day.avghumidity.toString() + "%"
    }

    val chanceOfRain: LiveData<String> = weatherData.map { weather ->
        "Chance of rain: " + weather.forecast.forecastday[1].day.daily_chance_of_rain.toString() + "%"
    }

    val chanceOfSnow: LiveData<String> = weatherData.map { weather ->
        "Chance of snow: " + weather.forecast.forecastday[1].day.daily_chance_of_snow.toString() + "%"
    }

    val uv: LiveData<String> = weatherData.map { weather ->
        "UV: " + weather.forecast.forecastday[1].day.uv.toString()
    }

    private fun updateWeather(weather: WeatherForecastResponseEntity?) {
        viewModelScope.launch {
            if (weather != null) {
                weatherData.postValue(weather)
            }
        }
    }
}
