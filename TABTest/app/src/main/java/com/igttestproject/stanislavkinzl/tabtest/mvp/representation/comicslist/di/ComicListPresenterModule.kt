package com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.di

import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.ComicsListContract
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.ComicsListPresenter
import dagger.Module
import dagger.Provides


@Module
class ComicListPresenterModule {

    @Provides
    fun provideComicsListPresenter(): ComicsListPresenter {
        return ComicsListPresenter()
    }
}