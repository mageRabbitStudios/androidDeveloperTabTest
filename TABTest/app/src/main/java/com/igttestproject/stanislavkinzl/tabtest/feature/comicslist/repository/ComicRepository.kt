package com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.igttestproject.stanislavkinzl.tabtest.app.database.remote.ApiInterface
import com.igttestproject.stanislavkinzl.tabtest.app.model.Comic
import com.igttestproject.stanislavkinzl.tabtest.app.database.remote.GetComicsResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import java.util.*
import javax.inject.Inject

interface ComicRepository {
    fun fetchComics(): Single<List<Comic>>//: Single<List<Comic>>
}

class ComicRepositoryImpl @Inject constructor(
        private val apiInterface: ApiInterface,
        private val mapper: ComicMapper
) : ComicRepository {

    override fun fetchComics(): Single<List<Comic>> = apiInterface.allComics().map(mapper::map)

}