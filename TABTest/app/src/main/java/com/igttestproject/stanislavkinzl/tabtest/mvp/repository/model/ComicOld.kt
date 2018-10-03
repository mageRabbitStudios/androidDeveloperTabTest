package com.igttestproject.stanislavkinzl.tabtest.mvp.repository.model

import com.google.gson.annotations.SerializedName

class ComicOld {

    @SerializedName("title ")
    var name: String? = null

    @SerializedName("thumbnail")
    var thumbnail: Int? = null

    constructor(name: String, thumbnail: Int) {
        this.name = name
        this.thumbnail = thumbnail
    }
}