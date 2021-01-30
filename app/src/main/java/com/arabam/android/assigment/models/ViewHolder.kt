package com.arabam.android.assigment.models

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.arabam.android.assigment.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class ViewHolder constructor(val carView: View) :
        RecyclerView.ViewHolder(carView) {
    val cardView: CardView = itemView.findViewById(R.id.cardview)
    val carPhoto: ImageView = carView.findViewById(R.id.photo)
    val carTitle: TextView = carView.findViewById(R.id.title)
    val carModelName: TextView = carView.findViewById(R.id.modelName)
    val carPrice: TextView =carView.findViewById(R.id.price)

    fun bind(carModel: CarModel){
        carTitle.setText(carModel.title)
        carModelName.setText(carModel.modelName)
        carPrice.setText(carModel.priceFormatted)

        val requestOptions= RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

        Glide.with(carView)
                .applyDefaultRequestOptions(requestOptions)
                .load(carModel.photo)
                .into(carPhoto)
    }
}