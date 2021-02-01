package com.arabam.android.assigment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arabam.android.assigment.R

class CarDetailImageAdapter : RecyclerView.Adapter<CarDetailImageViewHolder>() {
    private var imageUrls = listOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarDetailImageViewHolder =
        CarDetailImageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.car_detail_image, parent, false)
        )

    override fun getItemCount(): Int = imageUrls.size

    override fun onBindViewHolder(holder: CarDetailImageViewHolder, position: Int) =
        holder.bind(imageUrls[position])

    fun submitList(imageUrls: List<String>?) {
        this.imageUrls = imageUrls ?: emptyList()
        notifyDataSetChanged()
    }
}

