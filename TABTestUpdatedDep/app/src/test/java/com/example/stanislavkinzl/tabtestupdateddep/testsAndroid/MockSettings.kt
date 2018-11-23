package com.example.stanislavkinzl.tabtestupdateddep.testsAndroid

import com.example.stanislavkinzl.tabtestupdateddep.app.database.remote.ApiInterface
import java.net.HttpURLConnection

object MockSettings {

    object EndpointJsons {
        const val GET_COMICS_FULL = "comics/all_comics_list.json"
        const val GET_COMICS_EMPTY = "comics/all_comics_list_empty.json"
    }

    object EndpointValues {
        var GET_COMICS =
            EndpointJsons.GET_COMICS_FULL
    }

    object EndpointStatus {
        var GET_COMICS = HttpURLConnection.HTTP_OK
    }

    fun getEndpointResponse(name: String): Pair<Int, String> = when (name) {
        ApiInterface.Endpoints.GET_COMICS -> Pair(
            EndpointStatus.GET_COMICS,
            EndpointValues.GET_COMICS
        )
        else -> Pair(500, "")
    }

    fun updateEndpointValue(name: String, value: String) {
        when (name) {
            ApiInterface.Endpoints.GET_COMICS -> EndpointValues.GET_COMICS = value
        }
    }
}