package com.arabam.android.assigment.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.arabam.android.assigment.models.CarItem
import com.arabam.android.assigment.models.State
import com.arabam.android.assigment.repository.CarDataSource
import com.arabam.android.assigment.repository.CarDataSourceFactory
import com.arabam.android.assigment.repository.CarRepository
import com.arabam.android.assigment.repository.CarRepository.Companion.TAKE_COUNT
import io.reactivex.disposables.CompositeDisposable

class CarListViewModel() : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val carRepository: CarRepository = CarRepository()
    private val carDataSourceFactory =
        CarDataSourceFactory(carRepository, compositeDisposable)

    private var carList: LiveData<PagedList<CarItem>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(TAKE_COUNT)
            .setInitialLoadSizeHint(TAKE_COUNT * 2)
            .setEnablePlaceholders(false)
            .build()
        carList = LivePagedListBuilder(carDataSourceFactory, config).build()
    }

    fun getState(): LiveData<State> = Transformations.switchMap(
        carDataSourceFactory.carDataSourceLiveData,
        CarDataSource::state
    )

    fun retry() {
        carDataSourceFactory.carDataSourceLiveData.value?.retry()
    }

    fun getCarList() = carList

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
