package com.arabam.android.assigment.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.arabam.android.assigment.models.CarItem
import com.arabam.android.assigment.models.FetchState
import com.arabam.android.assigment.repository.CarRepository.Companion.TAKE_COUNT
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers

class CarDataSource(
    private val carRepository: CarRepository,
    private val compositeDisposable: CompositeDisposable,
) : PageKeyedDataSource<Int, CarItem>() {

    var state: MutableLiveData<FetchState> = MutableLiveData()
    private var retryCompletable: Completable? = null
    private var isLastPage = false

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, CarItem>,
    ) {
        load(0) { before, next, response -> callback.onResult(response, before, next) }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, CarItem>) {

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, CarItem>) {
        load(params.key) { _, next, response -> callback.onResult(response, next) }
    }

    private fun load(
        page: Int,
        callback: (before: Int?, next: Int?, result: List<CarItem>) -> Unit,
    ) {
        updateState(FetchState.LOADING)
        compositeDisposable.add(
            carRepository.getCarList(TAKE_COUNT * page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { response ->
                        isLastPage = response.size < TAKE_COUNT
                        updateState(FetchState.DONE)
                        callback(
                            if (page == 0) null else page - 1,
                            if (isLastPage) null else page + 1,
                            response
                        )
                    }
                ) {
                    updateState(FetchState.ERROR)
                    Log.e(CarDataSource::class.toString(), "Car List Fetch Error", it)
                    setRetry {
                        if (isLastPage.not())
                            load(page, callback)
                    }
                }
        )
    }

    private fun updateState(state: FetchState) {
        this.state.postValue(state)
    }

    fun retry() {
        if (retryCompletable != null) {
            compositeDisposable.add(
                retryCompletable!!
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            )
        }
    }

    private fun setRetry(action: Action?) {
        retryCompletable = if (action == null) null else Completable.fromAction(action)
    }

}