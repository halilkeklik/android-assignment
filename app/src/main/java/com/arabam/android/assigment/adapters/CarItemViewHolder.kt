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
        private val view: View
) : RecyclerView.ViewHolder(view) {
    private val imageView: ImageView = view.findViewById(R.id.photo)
    private val titleTextView: TextView = view.findViewById(R.id.title)
    private val modelNameTextView: TextView = view.findViewById(R.id.modelName)
    private val priceTextView: TextView = view.findViewById(R.id.price)

    fun bind(carItem: CarItem) {

        val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)

        Glide.with(view.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(carItem.photo)
                .into(imageView)

        titleTextView.text = carItem.title
        modelNameTextView.text = carItem.dateFormatted


        priceTextView.text = carItem.priceFormatted
                ?: view.context.getString(R.string.price_formatted, carItem.price)

    }
}