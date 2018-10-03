package br.com.nglauber.marvel.model.api.paging

import android.arch.paging.DataSource
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.MarvelApi
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.entity.Comic
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.paging.ComicsDataSource
import io.reactivex.disposables.CompositeDisposable

class ComicsDataSourceFactory(
        private val compositeDisposable: CompositeDisposable,
        private val marvelApi: MarvelApi
) : DataSource.Factory<Int, Comic>() {

    override fun create(): DataSource<Int, Comic> {
        return ComicsDataSource(marvelApi, compositeDisposable)
    }
}