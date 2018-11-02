package com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import com.igttestproject.stanislavkinzl.tabtest.mvp.base.BasePresenter
import com.igttestproject.stanislavkinzl.tabtest.mvp.base.BaseView
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.Comic

interface ComicsListContract {

    interface Presenter : BasePresenter<View> {
        fun setUpToolbar(view: android.view.View)
        fun fetchComics(view: android.view.View)
        fun initRecyclerView(view: android.view.View): RecyclerView
    }

    interface View : BaseView {
        fun displayToolbar(toolbar: Toolbar)
        fun onMemesFetched(comicsList: List<Comic>)
    }
}