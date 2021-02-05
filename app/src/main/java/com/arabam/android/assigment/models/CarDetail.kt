package com.arabam.android.assigment.models

import com.google.gson.annotations.SerializedName

data class CarDetail(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String?,
    @SerializedName("modelName")
    val modelName: String?,
    @SerializedName("price")
    val price: Double,
    @SerializedName("priceFormatted")
    val priceFormatted: String?,
    @SerializedName("date")
    val date: String,
    @SerializedName("dateFormatted")
    val dateFormatted: String?,
    @SerializedName("photos")
    val photos: List<String>?,
    @SerializedName("location")
    val location: Location,
    @SerializedName("category")
    val category: Category,
    @SerializedName("properties")
    val properties: List<Properties>,
    @SerializedName("userInfo")
    val userInfo: UserInfo,
    @SerializedName("text")
    val text: String?
)

