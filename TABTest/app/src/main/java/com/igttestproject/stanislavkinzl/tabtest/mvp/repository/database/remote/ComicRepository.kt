package com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote

import io.reactivex.Single
import javax.inject.Inject

interface ComicRepository {
    //fun getComics(): Single<List<Comic>>
}

class ComicRepositoryImpl @Inject constructor(
        private val apiInterface: ApiInterface,
        private val mapper: ComicMapper
) : ComicRepository {

    // override fun getComics(): Single<List<Comic>> = apiInterface.allComics().map(mapper::map)
   // override fun getComics(): Single<List<Comic>> = apiInterface.allComics().map(mapper::map)
}