package com.example.weatherforecast.ui.viewmodels

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.domain.CityEntity
import com.example.weatherforecast.ui.CityRecycleViewAdapter
import com.example.weatherforecast.usecases.GetCities
import kotlinx.coroutines.launch

class CityListViewModel(private val getCities: GetCities) : ViewModel() {

    val data = MutableLiveData<List<CityViewModel>>(emptyList())

    init {
        viewModelScope.launch {
            val cities = getCities()

            data.postValue(createViewData(cities))
        }
    }

    private fun createViewData(cities: List<CityEntity>) : List<CityViewModel> {
        val cityViewModels = mutableListOf<CityViewModel>()

        cities.forEach {cityEntity ->
            cityViewModels.add(CityViewModel(cityEntity.name, cityEntity.country))
        }

        return cityViewModels
    }

    companion object {
        @JvmStatic
        @BindingAdapter("cityViewModels")
        fun bindCityViewModels(recyclerView: RecyclerView, cityViewModels: List<CityViewModel>?) {
            val adapter = getOrCreateAdapter(recyclerView)
            adapter.updateCities(cityViewModels)
        }

        private fun getOrCreateAdapter(recyclerView: RecyclerView): CityRecycleViewAdapter {
            return if (recyclerView.adapter != null && recyclerView.adapter is CityRecycleViewAdapter) {
                recyclerView.adapter as CityRecycleViewAdapter
            }
            else {
                recyclerView.adapter = CityRecycleViewAdapter()
                recyclerView.adapter as CityRecycleViewAdapter
            }
        }
    }
}
