package com.arabam.android.assigment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arabam.android.assigment.R
import com.arabam.android.assigment.models.CarItem

class CarItemAdapter() : RecyclerView.Adapter<CarItemViewHolder>() {

    private var carlist: List<CarItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarItemViewHolder {
        return CarItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holderCarItem: CarItemViewHolder, position: Int) {
        when (holderCarItem) {
            is CarItemViewHolder -> {
                holderCarItem.bind(carlist[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return carlist.size
    }

    fun submitList(carList: List<CarItem>) {
        this.carlist = carList
        notifyDataSetChanged()
    }

}