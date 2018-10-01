package com.igttestproject.stanislavkinzl.tabtest.presenter

import com.igttestproject.stanislavkinzl.tabtest.repository.database.DatabaseComicsRepository
import com.igttestproject.stanislavkinzl.tabtest.view.IMainActivityView

class MainActivityPresenter(internal var view: IMainActivityView,
                            private var repository: DatabaseComicsRepository) {
    fun loadComics() {
        view.displayProof(repository.getProof())
    }
}