package com.igttestproject.stanislavkinzl.tabtest.app.database.remote

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    //use Single later

    @GET(Endpoints.GET_COMICS)
    fun allComics(): Single<GetComicsResponse>

    object Endpoints {
        const val GET_COMICS = "comics"
    }
}