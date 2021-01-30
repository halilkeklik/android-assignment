package com.arabam.android.assigment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arabam.android.assigment.models.CarModel
import com.arabam.android.assigment.models.ViewHolder

class Adapter(): RecyclerView.Adapter<ViewHolder>() {

    private var carlist: List<CarModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.activity_main,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(holder){
            is ViewHolder ->{
                holder.bind(carlist.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return carlist.size
    }

    fun submitList(carList: List<CarModel>) {
        carlist = carList
    }



}