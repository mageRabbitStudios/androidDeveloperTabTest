package com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.domain.FetchComicsUseCase

class ComicsViewModelImpl constructor(
    private val fetchComicsUseCase: FetchComicsUseCase
): ComicsViewModel(), FetchComicsUseCase.Callback {

    init { fetchComicsUseCase.setCallback(this) }

    //callbacks
    override fun onFetchComicsResult(result: FetchComicsUseCase.Result) {
        when (result) {

            is FetchComicsUseCase.Result.Success -> state.value =
                    ComicsViewModel.State.FetchMemesSuccess(result.comics)

               FetchComicsUseCase.Result.Error   -> state.value =
                    ComicsViewModel.State.FetchMemesError
        }
    }

    //view model
    override fun state(): LiveData<State> = state

    override fun getComicsApiList() {
        fetchComicsUseCase.execute()
    }

    private val state: MutableLiveData<State> = MutableLiveData()

}
