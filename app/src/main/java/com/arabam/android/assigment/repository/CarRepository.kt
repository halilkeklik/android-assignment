package com.arabam.android.assigment.repository

import com.arabam.android.assigment.api.ArabamAPIService
import com.arabam.android.assigment.models.CarDetail
import com.arabam.android.assigment.models.CarItem
import io.reactivex.Single

class CarRepository {
    private val arabamAPIService = ArabamAPIService()

    companion object {
        public const val TAKE_COUNT = 50
    }

    fun getCarList(skip: Int = 0, take: Int = TAKE_COUNT): Single<List<CarItem>> {
        return arabamAPIService.getCarList(skip, take)
    }

    fun getCarDetail(id: Int): Single<CarDetail> {
        return arabamAPIService.getCarDetail(id)
    }

}