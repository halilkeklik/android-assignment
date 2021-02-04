package com.arabam.android.assigment.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arabam.android.assigment.R
import com.arabam.android.assigment.models.Properties


class CarDetailPropertiesViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val propertiesValueTextView: TextView = view.findViewById(R.id.value)
    private val propertiesNameTextView: TextView = view.findViewById(R.id.detail_name)

    fun bind(properties: Properties) {
        propertiesValueTextView.text = properties.value
        propertiesNameTextView.text = properties.name
    }
}