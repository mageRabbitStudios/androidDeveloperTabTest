package com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.repository

import com.igttestproject.stanislavkinzl.tabtest.app.database.remote.ApiInterface
import com.igttestproject.stanislavkinzl.tabtest.app.model.Comic
import io.reactivex.Single
import javax.inject.Inject

interface ComicRepository {
    fun fetchComics(): Single<List<Comic>>
}

class ComicRepositoryImpl @Inject constructor(
        private val apiInterface: ApiInterface,
        private val mapper: ComicMapper
) : ComicRepository {

    override fun fetchComics(): Single<List<Comic>> = apiInterface.allComics().map(mapper::map)

}