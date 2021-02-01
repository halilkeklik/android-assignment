package com.arabam.android.assigment.models

data class CarDetail(
    val id: Int,
    val title: String?,
    val modelName: String?,
    val price: Double,
    val priceFormatted: String?,
    val date: String,
    val dateFormatted: String?,
    val photos: List<String>?,
    val location: Location,
    val category: Category,
    val properties: List<Properties>,
    val userInfo: UserInfo
)

