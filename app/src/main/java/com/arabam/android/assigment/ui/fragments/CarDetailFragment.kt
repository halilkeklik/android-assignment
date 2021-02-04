package com.arabam.android.assigment.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.arabam.android.assigment.R
import com.arabam.android.assigment.adapters.CarDetailImageAdapter
import com.arabam.android.assigment.adapters.CarDetailPropertiesAdapter
import com.arabam.android.assigment.models.CarDetail
import com.arabam.android.assigment.repository.CarRepository

class CarDetailFragment : Fragment(R.layout.fragment_car_detail) {

    private lateinit var viewPager2: ViewPager2
    private lateinit var viewPagerAdapter: CarDetailImageAdapter
    private lateinit var carDetail: CarDetail
    private lateinit var propertiesView: RecyclerView
    private lateinit var propertiesAdapter: CarDetailPropertiesAdapter
    lateinit var detailTitleTextView: TextView
    lateinit var detailPriceTextView: TextView
    lateinit var detailModelTextView: TextView
    lateinit var detailDateTextView: TextView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager2 = view.findViewById(R.id.viewPager2)
        viewPagerAdapter = CarDetailImageAdapter()
        propertiesView = view.findViewById(R.id.detail_properties)
        propertiesAdapter = CarDetailPropertiesAdapter()
        carDetail = CarRepository.getCarDetail()

        detailTitleTextView = view.findViewById(R.id.detail_title)
        detailModelTextView = view.findViewById(R.id.detail_model)
        detailPriceTextView = view.findViewById(R.id.detail_price)
        detailDateTextView=view.findViewById(R.id.detail_date)
        detailTitleTextView.text = carDetail.title
        detailModelTextView.text = carDetail.modelName
        detailDateTextView.text= carDetail.dateFormatted
        detailPriceTextView.text = carDetail.priceFormatted ?: view.context.getString(R.string.price_formatted, carDetail.price)

        viewPager2.adapter = viewPagerAdapter
        viewPagerAdapter.submitList(carDetail.photos)

        propertiesView.adapter = propertiesAdapter
        propertiesAdapter.submitList(carDetail.properties)
        propertiesView.layoutManager = LinearLayoutManager(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = arguments?.getInt("id")
    }


}