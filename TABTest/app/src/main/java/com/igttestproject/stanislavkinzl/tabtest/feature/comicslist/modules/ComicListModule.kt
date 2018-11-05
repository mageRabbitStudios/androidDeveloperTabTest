package com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.modules

import android.arch.lifecycle.ViewModelProviders
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.domain.FetchComicsUseCase
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.domain.FetchComicsUseCaseImpl
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.view.MainActivity
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.repository.ComicRepository
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.repository.ComicRepositoryImpl
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.viewmodel.ComicsViewModel
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.viewmodel.ComicsViewModelFactory
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.widget.comicslist.injection.ComicsListWidgetModule
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.widget.toolbar.injection.ToolbarWidgetModule
import dagger.Module
import dagger.Provides


@Module(includes = [
    ComicsListWidgetModule::class,
    ToolbarWidgetModule::class
])
class ComicListModule {

    @Provides
    fun provideComicsViewModel(mainActivity: MainActivity, memeViewModelFactory: ComicsViewModelFactory): ComicsViewModel =
            ViewModelProviders.of(mainActivity, memeViewModelFactory).get(ComicsViewModel::class.java)


    @Provides
    fun provideComicRepository(comicRepository: ComicRepositoryImpl): ComicRepository =
            comicRepository

    @Provides
    fun provideComicsUseCase(fetchComicsUseCase: FetchComicsUseCaseImpl): FetchComicsUseCase =
            fetchComicsUseCase

}