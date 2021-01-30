package com.arabam.android.assigment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arabam.android.assigment.models.CarModel

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var caradapter:Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        recyclerView=findViewById(R.id.recyclerview)
        initRecyclerView()
        addCarList()
    }

    private fun addCarList(){
        val carlist = CarList.createCarList()
        caradapter.submitList(carlist)
    }

    private fun initRecyclerView(){
        recyclerView.apply {
            layoutManager= LinearLayoutManager(this@MainActivity)
            caradapter= Adapter()
            adapter=caradapter
        }
    }

}