package com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.domain

import com.igttestproject.stanislavkinzl.tabtest.app.model.Comic

interface  FetchComicsUseCase {

    sealed class Result {
        data class Success(val comics: List<Comic>) : Result()
        object Error : Result()
    }

    interface Callback {
        fun onFetchComicsResult(result: Result)
    }

    fun execute()

    fun setCallback(callback: Callback)

    fun clean()

}