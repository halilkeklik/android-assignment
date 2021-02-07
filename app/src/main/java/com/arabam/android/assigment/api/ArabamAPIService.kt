package com.arabam.android.assigment.api

import com.arabam.android.assigment.models.CarDetail
import com.arabam.android.assigment.models.CarItem
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ArabamAPIService {
    private val baseURL = "http://sandbox.arabamd.com/"

    private val arabamApi = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build().create(ArabamAPI::class.java)

    fun getCarList(skip: Int, take: Int): Single<List<CarItem>> {
        return arabamApi.getCarItem(skip, take)
    }

    fun getCarDetail(id: Int): Single<CarDetail> {
        return arabamApi.getDetail(id)
    }
}