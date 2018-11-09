package com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.dependencyinjection

import android.arch.lifecycle.ViewModelProviders
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.domain.FetchComicsUseCase
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.domain.FetchComicsUseCaseImpl
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.repository.ComicRepository
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.repository.ComicRepositoryImpl
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.view.MainActivity
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.viewmodel.ComicsViewModel
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.viewmodel.ComicsViewModelFactory
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.widget.widget_comicslist.injection.ComicsListWidgetModule
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.widget.widget_marveltoolbar.injection.ToolbarWidgetModule
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