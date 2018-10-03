package com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.entity

data class Comic(
        val id: Int,
        val title: String,
        val description: String,
        val thumbnail: Thumbnail,
        val pageCount: Int
)