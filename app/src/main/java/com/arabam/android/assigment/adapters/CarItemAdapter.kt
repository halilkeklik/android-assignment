package com.arabam.android.assigment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.arabam.android.assigment.R
import com.arabam.android.assigment.models.CarItem

class CarItemAdapter(
    var onItemClickListener: OnItemClickListener,
) : PagedListAdapter<CarItem, CarItemViewHolder>(DataDiffCallback) {

    interface OnItemClickListener {
        fun onItemClicked(id: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarItemViewHolder {
        return CarItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holderCarItem: CarItemViewHolder, position: Int) {
        getItem(position)?.let {
            holderCarItem.bind(it)
            holderCarItem.itemView.setOnClickListener {
                onItemClickListener.onItemClicked(it.id)
            }
        }

    }

    companion object {
        val DataDiffCallback = object : DiffUtil.ItemCallback<CarItem>() {
            override fun areItemsTheSame(
                oldItem: CarItem,
                newItem: CarItem,
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: CarItem,
                newItem: CarItem,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

}