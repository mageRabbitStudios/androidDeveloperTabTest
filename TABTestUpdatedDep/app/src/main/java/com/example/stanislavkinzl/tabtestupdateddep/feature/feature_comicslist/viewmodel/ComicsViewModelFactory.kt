package com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.domain.FetchComicsUseCase
import javax.inject.Inject

class ComicsViewModelFactory @Inject constructor(
    private val fetchComicsUseCase: FetchComicsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ComicsViewModelImpl(
            fetchComicsUseCase
        ) as T
    }

}