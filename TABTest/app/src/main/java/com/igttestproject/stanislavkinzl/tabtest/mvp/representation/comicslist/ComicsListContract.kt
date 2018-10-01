package com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist

import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.model.Comic
import com.igttestproject.stanislavkinzl.tabtest.mvp.base.BasePresenter
import com.igttestproject.stanislavkinzl.tabtest.mvp.base.BaseView

interface ComicsListContract {

    interface Presenter : BasePresenter<View> {

        fun refreshComicList()
        fun fetchComicList(showLoading: Boolean)
        fun proofOfMvp(proof: String)

    }

    interface View : BaseView {
        fun showComicList(comicList: List<Comic>)
        fun showProof(proof: String)
    }
}