package com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.model

import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.ComicRepository

class ComicsViewModelImpl constructor(
        private val comicRepository: ComicRepository
): ComicsViewModel() {

    override fun fetchComicsList() {
        comicRepository.fetchComics()
    }

    /* fun getMemeLiveData(): LiveData<ArrayList<Comic>> {
         return comicRepository.gtComicListData()
     }*/

}