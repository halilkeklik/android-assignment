package com.arabam.android.assigment.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.arabam.android.assigment.models.CarItem
import io.reactivex.disposables.CompositeDisposable

class CarDataSourceFactory(
    private val repository: CarRepository,
    private val compositeDisposable: CompositeDisposable
) : DataSource.Factory<Int, CarItem>() {

    val carDataSourceLiveData = MutableLiveData<CarDataSource>()

    override fun create(): DataSource<Int, CarItem> {
        val carDataSource = CarDataSource(repository, compositeDisposable)
        carDataSourceLiveData.postValue(carDataSource)
        return carDataSource
    }
}