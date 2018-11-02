package com.igttestproject.stanislavkinzl.tabtest.proj.database.remote

import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    //use Single later

    @GET(Endpoints.GET_COMICS)
    fun allComics(): Call<GetComicsResponse>

    object Endpoints {
        const val GET_COMICS = "comics"
    }
}