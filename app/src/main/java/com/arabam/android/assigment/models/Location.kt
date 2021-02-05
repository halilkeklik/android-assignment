package com.arabam.android.assigment.models

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("cityName")
    val cityName: String?,
    @SerializedName("townName")
    val townName: String?
)