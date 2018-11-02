package com.igttestproject.stanislavkinzl.tabtest.proj.representation.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.igttestproject.stanislavkinzl.tabtest.proj.database.remote.ApiInterface
import com.igttestproject.stanislavkinzl.tabtest.app.model.Comic
import com.igttestproject.stanislavkinzl.tabtest.proj.database.remote.GetComicsResponse
import retrofit2.Call
import retrofit2.Response
import java.util.*
import javax.inject.Inject

interface ComicRepository {
    fun fetchComics()//: Single<List<Comic>>
    fun gtComicListData(): LiveData<ArrayList<Comic>>
}

class ComicRepositoryImpl @Inject constructor(
        private val apiInterface: ApiInterface
) : ComicRepository {

    override fun gtComicListData(): LiveData<ArrayList<Comic>> {
        return comicResponseLiveData
    }

    private val comicResponseLiveData = MutableLiveData<ArrayList<Comic>>()


    override fun fetchComics()//: Single<List<Comic>>
    {
        val call = apiInterface.allComics()

        Log.i("TAG", "Fetch Meme Call Executed")
        call.enqueue(object : retrofit2.Callback<GetComicsResponse> {
            override fun onResponse(call: Call<GetComicsResponse>, response: Response<GetComicsResponse>) {
                Log.i("TAG", "On Response")

                val memes = response.body()!!.data
                val memeList = memes!!.comics
                val memeArrayList = ArrayList<Comic>()

                for (meme in memeList!!) {
                    memeArrayList.plus(Comic(
                            meme.name!!,
                            meme.thumbnail!!.path!!,
                            meme.thumbnail.extension!!,
                            meme.pageCount!!)
                    )
                    Log.i("TAG", "Logging " + meme.toString())

                }

                comicResponseLiveData.value = memeArrayList

            }

            override fun onFailure(call: Call<GetComicsResponse>, t: Throwable) {
                Log.e("TAG", "Request failed")

            }
        })
    }


    // override fun getComics(): Single<List<Comic>> = apiInterface.allComics().map(mapper::map)
   // override fun getComics(): Single<List<Comic>> = apiInterface.allComics().map(mapper::map)
}