package com.igttestproject.stanislavkinzl.tabtest.proj.comicslist.viewModel

import com.igttestproject.stanislavkinzl.tabtest.proj.comicslist.repository.ComicRepository

class ComicsViewModelImpl constructor(
        private val comicRepository: ComicRepository
): ComicsViewModel() {

    override fun fetchComicsList() {
        comicRepository.fetchComics()
    }
}
