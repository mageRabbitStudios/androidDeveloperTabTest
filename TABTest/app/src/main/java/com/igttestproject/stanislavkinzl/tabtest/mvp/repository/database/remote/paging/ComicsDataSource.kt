package com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.paging

import android.arch.paging.PageKeyedDataSource
import android.util.Log
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.MarvelApi
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.entity.Comic
import io.reactivex.disposables.CompositeDisposable

class ComicsDataSource(
        private val marvelApi: MarvelApi,
        private val compositeDisposable: CompositeDisposable
) : PageKeyedDataSource<Int, Comic>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Comic>) {
        val numberOfItems = params.requestedLoadSize
        createObservable(0, 1, numberOfItems, callback, null)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Comic>) {
        val page = params.key
        val numberOfItems = params.requestedLoadSize
        createObservable(page, page + 1, numberOfItems, null, callback)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Comic>) {
        val page = params.key
        val numberOfItems = params.requestedLoadSize
        createObservable(page, page - 1, numberOfItems, null, callback)
    }

    private fun createObservable(requestedPage: Int,
                                 adjacentPage: Int,
                                 requestedLoadSize: Int,
                                 initialCallback: LoadInitialCallback<Int, Comic>?,
                                 callback: LoadCallback<Int, Comic>?) {
        compositeDisposable.add(
                marvelApi.allComics()//requestedPage * requestedLoadSize)
                        .subscribe(
                                { response ->
                                    Log.d("NGVL", "Loading page: $requestedPage")
                                    initialCallback?.onResult(response.data.results, null, adjacentPage)
                                    callback?.onResult(response.data.results, adjacentPage)
                                },
                                { t ->
                                    Log.d("NGVL", "Error loading page: $requestedPage", t)
                                }
                        )
        )
    }
}