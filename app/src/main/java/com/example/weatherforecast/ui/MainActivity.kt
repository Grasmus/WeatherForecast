package com.example.weatherforecast.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.weatherforecast.BuildConfig
import com.example.weatherforecast.data.repositories.CityRepository
import com.example.weatherforecast.data.repositories.ICitySource
import com.example.weatherforecast.data.repositories.IWeatherSource
import com.example.weatherforecast.data.repositories.WeatherRepository
import com.example.weatherforecast.data.sources.CitySource
import com.example.weatherforecast.data.sources.WeatherSource
import com.example.weatherforecast.databinding.ActivityMainBinding
import com.example.weatherforecast.domain.usecases.GetCities
import com.example.weatherforecast.domain.usecases.GetWeather
import com.example.weatherforecast.domain.usecases.ICityRepository
import com.example.weatherforecast.domain.usecases.IWeatherRepository
import com.example.weatherforecast.ui.cityview.CityListViewModel
import com.example.weatherforecast.ui.weatherview.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

class MainActivity: AppCompatActivity() {
    private val binding: ActivityMainBinding by viewBinding(CreateMethod.INFLATE)

    private val mainModule = module {
        singleOf<ICitySource>(::CitySource)
        single<ICityRepository> { CityRepository(get()) }
        singleOf(::GetCities)
        viewModelOf(::CityListViewModel)

        single<IWeatherSource> { WeatherSource(BuildConfig.WEATHER_API_URL, BuildConfig.WEATHER_API_KEY) }
        single<IWeatherRepository> { WeatherRepository(get()) }
        singleOf(::GetWeather)
        viewModel { params -> WeatherViewModel(get(), city = params.get()) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        startKoin{
            modules(mainModule)
        }
    }
}
