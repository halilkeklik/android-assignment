package com.arabam.android.assigment.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
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
import com.arabam.android.assigment.models.CarItem
import com.arabam.android.assigment.repository.CarRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CarDetailFragment : Fragment(R.layout.fragment_car_detail) {

    private lateinit var viewPager2: ViewPager2
    private lateinit var viewPagerAdapter: CarDetailImageAdapter
    private lateinit var carRepository: CarRepository
    private lateinit var propertiesView: RecyclerView
    private lateinit var propertiesAdapter: CarDetailPropertiesAdapter
    lateinit var detailTitleTextView: TextView
    lateinit var detailPriceTextView: TextView
    lateinit var detailModelTextView: TextView
    lateinit var detailDateTextView: TextView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getInt("id")
        viewPager2 = view.findViewById(R.id.viewPager2)
        viewPagerAdapter = CarDetailImageAdapter()
        propertiesView = view.findViewById(R.id.detail_properties)
        propertiesAdapter = CarDetailPropertiesAdapter()
        carRepository = CarRepository()


        detailTitleTextView = view.findViewById(R.id.detail_title)
        detailModelTextView = view.findViewById(R.id.detail_model)
        detailPriceTextView = view.findViewById(R.id.detail_price)
        detailDateTextView=view.findViewById(R.id.detail_date)

        if (id != null) {
            getCarDetail(id)
        }

    }

    @SuppressLint("CheckResult")
    fun getCarDetail(id:Int){
        carRepository.getCarDetail(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<CarDetail>() {
                override fun onSuccess(carDetail: CarDetail) {
                    detailTitleTextView.text = carDetail.title
                    detailModelTextView.text = carDetail.modelName
                    detailDateTextView.text= carDetail.dateFormatted
                    detailPriceTextView.text = carDetail.priceFormatted

                    viewPager2.adapter = viewPagerAdapter
                    viewPagerAdapter.submitList(carDetail.photos)

                    propertiesView.adapter = propertiesAdapter
                    propertiesAdapter.submitList(carDetail.properties)
                    propertiesView.layoutManager = LinearLayoutManager(context)
                }

                override fun onError(e: Throwable) {
                    Log.e("CarDetail","Fetch Error",e)
                }

            })
    }
}