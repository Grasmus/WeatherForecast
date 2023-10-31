package com.example.weatherforecast.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.weatherforecast.data.CityRepository
import com.example.weatherforecast.data.ICitySource
import com.example.weatherforecast.data.IWeatherSource
import com.example.weatherforecast.data.WeatherRepository
import com.example.weatherforecast.databinding.ActivityMainBinding
import com.example.weatherforecast.framework.CitySource
import com.example.weatherforecast.framework.WeatherSource
import com.example.weatherforecast.ui.viewmodels.CityListViewModel
import com.example.weatherforecast.ui.viewmodels.WeatherViewModel
import com.example.weatherforecast.usecases.GetCities
import com.example.weatherforecast.usecases.GetWeather
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

class MainActivity: AppCompatActivity() {
    private val binding: ActivityMainBinding by viewBinding(CreateMethod.INFLATE)

    private val mainModule = module {
        singleOf<ICitySource>(::CitySource)
        singleOf(::CityRepository)
        singleOf(::GetCities)
        viewModelOf(::CityListViewModel)

        singleOf<IWeatherSource>(::WeatherSource)
        singleOf(::WeatherRepository)
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
