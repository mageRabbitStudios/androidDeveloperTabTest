package com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote
import javax.inject.Inject

class ComicMapper @Inject constructor() {
    /**
     * We hide all the dirt here. Make sure nothing is null in the response, as well as filter out any
     * model objects that don't match the contract (e.g. url in this case - sometimes servers are flaky
     * and don't send required data)
     */

    fun map(comicsResponse: GetComicsResponse): List<Comic> =
            comicsResponse.data?.comics?.mapNotNull(::mapOrNull) ?: ArrayList()

    private fun mapOrNull(comicItem: ComicItem): Comic? {
        if (comicItem.thumbnail!!.path == null) {
            return null
        }

        return Comic(
                name =       comicItem.name ?: "",
                url  =       comicItem.thumbnail.path!!,
                extenson =   comicItem.thumbnail.extension ?: "",
                pageCount =  comicItem.pageCount ?: 0
        )
    }
}