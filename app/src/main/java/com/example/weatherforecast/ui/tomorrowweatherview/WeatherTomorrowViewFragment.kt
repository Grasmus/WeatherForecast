package com.example.weatherforecast.ui.tomorrowweatherview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.weatherforecast.databinding.FragmentWeatherTomorrowViewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class WeatherTomorrowViewFragment : Fragment() {
    private val binding: FragmentWeatherTomorrowViewBinding by viewBinding(CreateMethod.INFLATE)
    private val viewModel: WeatherTomorrowViewModel by viewModel {
        parametersOf(
            WeatherTomorrowViewFragmentArgs.fromBundle(requireArguments()).lat,
            WeatherTomorrowViewFragmentArgs.fromBundle(requireArguments()).long
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }
}
