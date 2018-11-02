package com.igttestproject.stanislavkinzl.tabtest.proj.comicslist.viewModel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.igttestproject.stanislavkinzl.tabtest.proj.comicslist.repository.ComicRepository
import javax.inject.Inject

class ComicsViewModelFactory @Inject constructor(
        private val comicsRepository: ComicRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ComicsViewModelImpl(comicsRepository) as T
    }

}