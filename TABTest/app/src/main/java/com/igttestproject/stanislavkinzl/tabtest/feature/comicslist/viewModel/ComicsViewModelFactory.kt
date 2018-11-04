package com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.domain.FetchComicsUseCase
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.repository.ComicRepository
import javax.inject.Inject

class ComicsViewModelFactory @Inject constructor(
        private val fetchComicsUseCase: FetchComicsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ComicsViewModelImpl(fetchComicsUseCase) as T
    }

}