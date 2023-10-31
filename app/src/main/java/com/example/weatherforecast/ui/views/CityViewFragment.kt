package com.example.weatherforecast.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.weatherforecast.databinding.FragmentCityViewBinding
import com.example.weatherforecast.ui.viewmodels.CityListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CityViewFragment : Fragment() {
    private val binding: FragmentCityViewBinding by viewBinding(CreateMethod.INFLATE)
    private val viewModel: CityListViewModel by viewModel()

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
        fun newInstance() = CityViewFragment()
    }
}
