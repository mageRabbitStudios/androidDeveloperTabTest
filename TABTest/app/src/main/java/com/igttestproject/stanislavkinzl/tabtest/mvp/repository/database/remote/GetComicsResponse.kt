package com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote

import com.google.gson.annotations.SerializedName

data class GetComicsResponse(
    @SerializedName("data")         val data: Data?
)

data class Data(
    @SerializedName("results")      val results: List<Comic>
)

data class Comic(
    @SerializedName("id")           val id: Int,
    @SerializedName("title")        val title: String,
    @SerializedName("description")  val description: String,
    @SerializedName("thumbnail")    val thumbnail: Thumbnail,
    @SerializedName("pageCount")    val pageCount: Int
)

data class Thumbnail(
    @SerializedName("path")         val path: String,
    @SerializedName("extension")    val extension: String
)