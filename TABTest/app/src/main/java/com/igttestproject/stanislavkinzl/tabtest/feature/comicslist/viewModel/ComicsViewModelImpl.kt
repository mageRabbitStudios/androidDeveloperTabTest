package com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.viewModel

import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.repository.ComicRepository

class ComicsViewModelImpl constructor(
        private val comicRepository: ComicRepository
): ComicsViewModel() {

    override fun fetchComicsList() {
        comicRepository.fetchComics()
    }
}
