package com.example.stanislavkinzl.tabtestupdateddep.helpers

import com.example.stanislavkinzl.tabtestupdateddep.app.database.remote.ApiInterface
import java.net.HttpURLConnection

object MockSettings {

    object EndpointJsons {
        const val GET_COMICS_FULL = "comics/all_comics_list.json"
        const val GET_COMICS_EMPTY = "comics/all_comics_list_empty.json"
    }

    object EndpointValues {
        var GET_MEMES = EndpointJsons.GET_COMICS_FULL
    }

    object EndpointStatus {
        var GET_MEMES = HttpURLConnection.HTTP_OK
    }

    fun getEndpointResponse(name: String): Pair<Int, String> = when (name) {
        ApiInterface.Endpoints.GET_COMICS -> Pair(EndpointStatus.GET_MEMES, EndpointValues.GET_MEMES)
        else -> Pair(500, "")
    }

    fun updateEndpointValue(name: String, value: String) {
        when (name) {
            ApiInterface.Endpoints.GET_COMICS -> EndpointValues.GET_MEMES = value
        }
    }
}