package com.arabam.android.assigment.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arabam.android.assigment.R
import com.arabam.android.assigment.adapters.CarItemAdapter
import com.arabam.android.assigment.models.CarItem
import com.arabam.android.assigment.repository.CarRepository
import com.arabam.android.assigment.ui.activites.MainActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CarListFragment : Fragment(R.layout.fragment_car_list), CarItemAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var carItemAdapter: CarItemAdapter
    private lateinit var carRepository: CarRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerview)
        initRecyclerView()
        carRepository = CarRepository()
        addCarList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun addCarList() {
        carRepository.getCarList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<List<CarItem>>(){
                override fun onError(e: Throwable) {
                    Log.e("CarList","Fetch Error",e)
                }

                override fun onSuccess(carList: List<CarItem>) {
                    carItemAdapter.submitList(carList)
                }
            })
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