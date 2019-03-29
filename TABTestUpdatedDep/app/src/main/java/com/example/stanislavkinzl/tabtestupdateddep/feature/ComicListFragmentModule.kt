package com.example.stanislavkinzl.tabtestupdateddep.feature

import androidx.lifecycle.ViewModelProviders
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.domain.FetchComicsUseCase
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.domain.FetchComicsUseCaseImpl
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.repository.ComicRepository
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.repository.ComicRepositoryImpl
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.viewmodel.ComicsViewModel
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.viewmodel.ComicsViewModelFactory
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.widget.widget_comicslist.injection.ComicsListWidgetModule
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.widget.widget_marveltoolbar.injection.ToolbarWidgetModule
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        ComicsListWidgetModule::class,
        ToolbarWidgetModule::class
    ]
)
class ComicListFragmentModule {

    @Provides
    fun provideComicsViewModel(
        fragment: ExampleComicListFragment,
        memeViewModelFactory: ComicsViewModelFactory
    ): ComicsViewModel =
        ViewModelProviders.of(fragment, memeViewModelFactory).get(ComicsViewModel::class.java)


    @Provides
    fun provideComicRepository(comicRepository: ComicRepositoryImpl): ComicRepository =
        comicRepository

    @Provides
    fun provideComicsUseCase(fetchComicsUseCase: FetchComicsUseCaseImpl): FetchComicsUseCase =
        fetchComicsUseCase


}