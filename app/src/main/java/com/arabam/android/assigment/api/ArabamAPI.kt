package com.arabam.android.assigment.api

import com.arabam.android.assigment.models.CarDetail
import com.arabam.android.assigment.models.CarItem
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ArabamAPI {
    @GET("api/v1/listing?sort=1&sortDirection=0&take=10")
    fun getCarItem(): Single<List<CarItem>>
    @GET("api/v1/detail?")
    fun getDetail(@Query("id") id: Int): Single<CarDetail>
}