package com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.modules

import android.arch.lifecycle.ViewModelProviders
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.view.MainActivity
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.repository.ComicRepository
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.repository.ComicRepositoryImpl
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.viewModel.ComicsViewModel
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.viewModel.ComicsViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class ComicListModule {

    @Provides
    fun provideComicsViewModel(mainActivity: MainActivity, memeViewModelFactory: ComicsViewModelFactory): ComicsViewModel =
            ViewModelProviders.of(mainActivity, memeViewModelFactory).get(ComicsViewModel::class.java)


    @Provides
    fun provideComicRepository(comicRepository: ComicRepositoryImpl): ComicRepository =
            comicRepository

}