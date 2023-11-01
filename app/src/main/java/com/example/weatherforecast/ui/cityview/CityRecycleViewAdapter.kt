package com.example.weatherforecast.ui.cityview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.BR
import com.example.weatherforecast.R

class CityRecycleViewAdapter :
    RecyclerView.Adapter<CityRecycleViewAdapter.ViewHolder>() {

    private var cities: List<CityViewModel> = emptyList()

    class ViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(city: CityViewModel) {
            binding.setVariable(BR.viewModel, city)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding : ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.city_view_item,
            parent,
            false)

        return ViewHolder(binding)
    }

    override fun getItemCount() = cities.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            val action = CityViewFragmentDirections.actionCityViewFragmentToWeatherViewFragment(cities[position].name)

            it.findNavController().navigate(action)
        }

        holder.bind(cities[position])
    }

    fun updateCities(citiesUpdate: List<CityViewModel>?) {
        cities = citiesUpdate ?: emptyList()
        notifyDataSetChanged()
    }
}
