package com.arabam.android.assigment.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.arabam.android.assigment.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class FullScreenImageFragment : Fragment(R.layout.fragment_full_screen_image) {

    private lateinit var imageView: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView = view.findViewById(R.id.detail_image)
        arguments?.let {
            val imageUrl = it.getString("url")!!
            bind(imageUrl)
        }
    }

    private fun bind(imageUrl: String) {
        val requestOptions = RequestOptions()
            .placeholder(R.mipmap.ic_launcher_foreground)
            .error(R.mipmap.ic_launcher_foreground)


        context?.let {
            Glide.with(it)
                .applyDefaultRequestOptions(requestOptions)
                .load(imageUrl.replace("{0}", "1920x1080", false))
                .centerCrop()
                .into(imageView)
        }
    }
}