package com.arabam.android.assigment.adapters

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.arabam.android.assigment.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CarDetailImageViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val imageView: ImageView = view.findViewById(R.id.detail_image)

    fun bind(imageUrl: String) {
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)


        Glide.with(view.context)
            .applyDefaultRequestOptions(requestOptions)
            .load(imageUrl)
            .into(imageView)
    }
}