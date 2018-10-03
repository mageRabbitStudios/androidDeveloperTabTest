package br.com.nglauber.marvel.model.api.paging

import android.arch.paging.DataSource
import android.arch.paging.PageKeyedDataSource
import android.util.Log
import br.com.nglauber.marvel.model.api.MarvelApi
import br.com.nglauber.marvel.model.api.entity.Character
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.MarvelApi
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.entity.Comic
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.paging.ComicsDataSource
import io.reactivex.disposables.CompositeDisposable

class CharactersDataSourceFactory(
        private val compositeDisposable: CompositeDisposable,
        private val marvelApi: MarvelApi
) : DataSource.Factory<Int, Comic>() {

    override fun create(): DataSource<Int, Comic> {
        return ComicsDataSource(marvelApi, compositeDisposable)
    }
}