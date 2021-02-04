package com.arabam.android.assigment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arabam.android.assigment.R
import com.arabam.android.assigment.models.Properties

class CarDetailPropertiesAdapter : RecyclerView.Adapter<CarDetailPropertiesViewHolder>() {
    private var properties = listOf<Properties>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CarDetailPropertiesViewHolder =
        CarDetailPropertiesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.car_detail_properties, parent, false)
        )


    override fun onBindViewHolder(holder: CarDetailPropertiesViewHolder, position: Int) =
        holder.bind(properties[position])

    override fun getItemCount(): Int {
        return properties.size
    }

    fun submitList(properties: List<Properties>?) {
        this.properties = properties ?: emptyList()
        notifyDataSetChanged()
    }

}