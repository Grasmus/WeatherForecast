package com.example.weatherforecast.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.weatherforecast.databinding.FragmentWeatherViewBinding
import com.example.weatherforecast.ui.viewmodels.WeatherViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class WeatherViewFragment : Fragment() {
    private val binding: FragmentWeatherViewBinding by viewBinding(CreateMethod.INFLATE)
    private val viewModel: WeatherViewModel by viewModel { parametersOf(WeatherViewFragmentArgs.fromBundle(requireArguments()).city) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = WeatherViewFragment()
    }
}
