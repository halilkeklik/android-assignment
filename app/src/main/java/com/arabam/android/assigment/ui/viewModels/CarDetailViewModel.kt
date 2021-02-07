package com.arabam.android.assigment.ui.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.arabam.android.assigment.models.CarDetail
import com.arabam.android.assigment.models.FetchState
import com.arabam.android.assigment.repository.CarRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CarDetailViewModel(savedState: SavedStateHandle) : ViewModel() {
    private val carDetail = MutableLiveData<CarDetail>()
    private val carRepository = CarRepository()
    private val compositeDisposable = CompositeDisposable()
    private val fetchState = MutableLiveData<FetchState>()

    init {
        val id = savedState.get<Int>("id")!!
        fetchCarDetail(id)
    }

    private fun fetchCarDetail(id: Int) {
        fetchState.postValue(FetchState.LOADING)
        compositeDisposable.add(
            carRepository.getCarDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<CarDetail>() {
                    override fun onSuccess(detail: CarDetail) {
                        fetchState.postValue(FetchState.DONE)
                        carDetail.postValue(detail)
                    }

                    override fun onError(e: Throwable) {
                        Log.e(CarDetailViewModel::class.toString(), "Car Detail Fetch Error", e)
                        fetchState.postValue(FetchState.ERROR)
                    }
                }
                )
        )
    }

    fun getCarDetail() = carDetail
    fun getState() = fetchState

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}