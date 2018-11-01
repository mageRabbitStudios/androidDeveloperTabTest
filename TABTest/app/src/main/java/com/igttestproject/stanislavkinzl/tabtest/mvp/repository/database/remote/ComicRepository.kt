package com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote

import io.reactivex.Single

interface ComicRepository {
    fun getComics(): Single<List<Comic>>
}