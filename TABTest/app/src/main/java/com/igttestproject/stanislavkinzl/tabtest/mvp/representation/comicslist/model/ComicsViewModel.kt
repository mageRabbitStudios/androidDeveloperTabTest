package com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.model

import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import android.arch.paging.RxPagedListBuilder
import com.igttestproject.stanislavkinzl.tabtest.COMICS_PREFETCH_DISTANCE
import com.igttestproject.stanislavkinzl.tabtest.PAGE_SIZE
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.ComicRepository

import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.Comic
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.Single.just
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ComicsViewModel : ViewModel() {

   // var comicsList: Observable<PagedList<Comic>>

    private val compositeDisposable = CompositeDisposable()

    private val pageSize = PAGE_SIZE

//    private val sourceFactory: ComicsDataSourceFactory


    val comicsList: Single<List<Comic>>
            //= comicsRepository.getComics()
    //private var disposable: Disposable? = null

    init {
        comicsList = Single.just(emptyList())

        //Comic("papa", "kaka", "jojo", 12)))
        /*      sourceFactory = ComicsDataSourceFactory(compositeDisposable)

        val config = PagedList.Config.Builder()
                .setPageSize(pageSize)
                .setInitialLoadSizeHint(pageSize * 2)
                .setPrefetchDistance(COMICS_PREFETCH_DISTANCE)
                .setEnablePlaceholders(false)
                .build()

        comicsList = RxPagedListBuilder(sourceFactory, config)
                .setFetchScheduler(Schedulers.io())
                .buildObservable()
                .cache()*/
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}