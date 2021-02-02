package com.arabam.android.assigment.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arabam.android.assigment.R
import com.arabam.android.assigment.adapters.CarItemAdapter
import com.arabam.android.assigment.repository.CarRepository
import com.arabam.android.assigment.ui.activites.MainActivity

class CarListFragment : Fragment(R.layout.fragment_car_list), CarItemAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var carItemAdapter: CarItemAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerview)
        initRecyclerView()
        addCarList()
    }

    private fun addCarList() {
        carItemAdapter.submitList(CarRepository.getCarList())
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            carItemAdapter = CarItemAdapter(this@CarListFragment)
            adapter = carItemAdapter
        }
    }

    override fun onItemClicked(id: Int) {
        (activity as MainActivity).showCarDetailFragment(id)
    }


}