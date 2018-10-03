package com.igttestproject.stanislavkinzl.tabtest.mvp.repository.model

import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import android.arch.paging.RxPagedListBuilder
import br.com.nglauber.marvel.model.api.paging.ComicsDataSourceFactory
import com.igttestproject.stanislavkinzl.tabtest.PAGE_SIZE

import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.MarvelApi
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.entity.Comic
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ComicsViewModel : ViewModel() {

    var comicsList: Observable<PagedList<Comic>>

    private val compositeDisposable = CompositeDisposable()

    private val pageSize = PAGE_SIZE

    private val sourceFactory: ComicsDataSourceFactory

    init {
        sourceFactory = ComicsDataSourceFactory(compositeDisposable, MarvelApi.getService())

        val config = PagedList.Config.Builder()
                .setPageSize(pageSize)
                .setInitialLoadSizeHint(pageSize * 2)
                .setPrefetchDistance(10)
                .setEnablePlaceholders(false)
                .build()

        comicsList = RxPagedListBuilder(sourceFactory, config)
                .setFetchScheduler(Schedulers.io())
                .buildObservable()
                .cache()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}