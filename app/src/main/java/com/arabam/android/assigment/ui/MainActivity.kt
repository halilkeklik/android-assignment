package com.arabam.android.assigment.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arabam.android.assigment.repository.CarRepository
import com.arabam.android.assigment.R
import com.arabam.android.assigment.adapters.CarItemAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var carItemAdapter: CarItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        recyclerView = findViewById(R.id.recyclerview)
        initRecyclerView()
        addCarList()
    }

    private fun addCarList() {
        carItemAdapter.submitList(CarRepository.getCarList())
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            carItemAdapter = CarItemAdapter()
            adapter = carItemAdapter
        }
    }

}