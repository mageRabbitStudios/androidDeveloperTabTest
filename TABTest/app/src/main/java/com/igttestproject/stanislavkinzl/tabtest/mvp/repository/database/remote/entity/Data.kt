package com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.entity

data class Data(
        val offset: Int,
        val limit: Int,
        val total: Int,
        val count: Int,
        val results: List<Comic>
)