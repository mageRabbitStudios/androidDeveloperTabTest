package com.igttestproject.stanislavkinzl.tabtest.repository.database

import com.igttestproject.stanislavkinzl.tabtest.repository.IComicsRepository
import com.karumi.marvelapiclient.ComicApiClient
import com.karumi.marvelapiclient.MarvelApiConfig

class DatabaseComicsRepository : IComicsRepository {

    private var marvelApiConfig: MarvelApiConfig? = null
    private var comicApiClient: ComicApiClient? = null

    private val publicKey = "d69b9581419ed36b6ef230f1f4e41fa4"
    private val privateKey = "0b7ac65c6413040c06b6f0a8ac04251e4a3cf16e"

    //primary constructor = init, constructor() = secondary constructor??
    init {
        marvelApiConfig = MarvelApiConfig.with(publicKey, privateKey)
        comicApiClient = ComicApiClient(marvelApiConfig)
    }


    override fun getProof(): String = "hmm"
}