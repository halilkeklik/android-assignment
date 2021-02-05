package com.arabam.android.assigment.repository

import com.arabam.android.assigment.api.ArabamAPIService
import com.arabam.android.assigment.models.*
import io.reactivex.Single

class CarRepository {
    val arabamAPIService = ArabamAPIService()

    fun getCarList(): Single<List<CarItem>> {
        return arabamAPIService.getCarList()
    }

    fun getCarDetail(id:Int): Single<CarDetail>{
        return arabamAPIService.getCarDetail(id)
    }

}