package com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.entity

data class Response (
    val code: Int,
    val etag: String,
    val data: Data
)