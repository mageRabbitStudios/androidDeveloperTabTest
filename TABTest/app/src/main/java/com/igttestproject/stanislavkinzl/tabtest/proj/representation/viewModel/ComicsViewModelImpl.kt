package com.igttestproject.stanislavkinzl.tabtest.proj.representation.viewModel

import com.igttestproject.stanislavkinzl.tabtest.proj.representation.repository.ComicRepository

class ComicsViewModelImpl constructor(
        private val comicRepository: ComicRepository
): ComicsViewModel() {

    override fun fetchComicsList() {
        comicRepository.fetchComics()
    }
}
