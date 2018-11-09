package com.example.stanislavkinzl.tabtestupdateddep.injection.modules

import android.arch.lifecycle.ViewModelProviders
import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.domain.FetchComicsUseCase
import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.domain.FetchComicsUseCaseImpl
import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.repository.ComicRepository
import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.repository.ComicRepositoryImpl
import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.view.MainActivity
import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.viewmodel.ComicsViewModel
import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.viewmodel.ComicsViewModelFactory
import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.widget.comicslist.injection.ComicsListWidgetModule
import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.widget.toolbar.injection.ToolbarWidgetModule
import dagger.Module
import dagger.Provides

@Module(includes = [
    ComicsListWidgetModule::class,
    ToolbarWidgetModule::class
])
class MockComicsListModule {
    @Provides
    fun provideMemeRepository(memeRepository: ComicRepositoryImpl): ComicRepository =
        memeRepository

    @Provides
    fun provideComicsUseCase(fetchComicsUseCase: FetchComicsUseCaseImpl): FetchComicsUseCase =
        fetchComicsUseCase

    @Provides
    fun provideComicsViewModel(mainActivity: MainActivity, memeViewModelFactory: ComicsViewModelFactory): ComicsViewModel =
        ViewModelProviders.of(mainActivity, memeViewModelFactory).get(ComicsViewModel::class.java)

}