package com.arabam.android.assigment.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arabam.android.assigment.R
import com.arabam.android.assigment.models.CarItem
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CarItemViewHolder(
    private val view: View,
) : RecyclerView.ViewHolder(view) {

    private val imageView: ImageView = view.findViewById(R.id.photo)
    private val titleTextView: TextView = view.findViewById(R.id.title)
    private val locationTextView: TextView = view.findViewById(R.id.location)
    private val priceTextView: TextView = view.findViewById(R.id.price)

    fun bind(carItem: CarItem) {

        val requestOptions = RequestOptions()
            .placeholder(R.mipmap.ic_launcher_foreground)
            .error(R.mipmap.ic_launcher_foreground)

        Glide.with(view.context)
            .applyDefaultRequestOptions(requestOptions)
            .load(carItem.photo?.replace("{0}", "580x435", false))
            .centerCrop()
            .into(imageView)

        titleTextView.text = carItem.title ?: view.context.getString(R.string.car_defult)
        locationTextView.text =
            if (carItem.location.cityName != null || carItem.location.townName != null)
                view.context.getString(R.string.location,
                    carItem.location.cityName,
                    carItem.location.townName)
            else
                view.context.getString(R.string.location_default)
        priceTextView.text = carItem.priceFormatted
            ?: view.context.getString(R.string.price_formatted, carItem.price)
    }
}