package com.arabam.android.assigment

import com.arabam.android.assigment.models.CarModel

class CarList {
    companion object {
        fun getCarList() {
            val carList = ArrayList<CarModel>()
            carList.add(
                    CarModel(
                            "Url",
                            "Car",
                            "Audi",
                            "500000",
                    )
            )
            carList.add(
                    CarModel(
                            "URl",
                            "Car2",
                            "BVM",
                            "40000000"
                    )
            )
        }
    }
}