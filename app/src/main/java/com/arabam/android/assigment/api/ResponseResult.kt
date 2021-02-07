package com.arabam.android.assigment.api

import com.arabam.android.assigment.models.CarItem
import com.squareup.moshi.Json

data class ResponseResult(
    @field:Json(name = "response") val response: List<CarItem>,
    @field:Json(name = "errorCode") val errorCode: String,
    @field:Json(name = "type") val type: String
)