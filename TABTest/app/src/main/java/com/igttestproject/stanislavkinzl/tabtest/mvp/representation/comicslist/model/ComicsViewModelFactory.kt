package com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.model

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.ComicRepository
import javax.inject.Inject

class ComicsViewModelFactory @Inject constructor(
        private val comicsRepository: ComicRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ComicsViewModelImpl(comicsRepository) as T
    }

}