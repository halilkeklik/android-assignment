package com.arabam.android.assigment.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.arabam.android.assigment.R
import com.arabam.android.assigment.adapters.CarDetailImageAdapter
import com.arabam.android.assigment.models.CarDetail
import com.arabam.android.assigment.repository.CarRepository

class CarDetailFragment : Fragment(R.layout.fragment_car_detail) {

    private lateinit var viewPager2: ViewPager2
    private lateinit var viewPagerAdapter: CarDetailImageAdapter
    private lateinit var carDetail: CarDetail
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager2 = view.findViewById(R.id.viewPager2)
        viewPagerAdapter = CarDetailImageAdapter()

        carDetail= CarRepository.getCarDetail()

        viewPager2.adapter = viewPagerAdapter
        viewPagerAdapter.submitList(carDetail.photos)
    }

}