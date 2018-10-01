package com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.di

import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.di.ScreenScoped
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.ComicsListContract
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.ComicsListPresenter
import dagger.Module
import dagger.Provides


@Module
class ComicListPresenterModule(private val contract: ComicsListContract.View) {

    private var view: ComicsListContract.View? = null

    @Provides
    @ScreenScoped
    internal fun provideView(): ComicsListContract.View {
        return contract
    }

    init {
        this.view = contract
    }

    @Provides
    fun provideComicsListPresenter(): ComicsListPresenter {
        return ComicsListPresenter()
    }
}