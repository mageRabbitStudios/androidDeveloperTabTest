package com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.igttestproject.stanislavkinzl.tabtest.mvp.base.BasePresenter
import com.igttestproject.stanislavkinzl.tabtest.mvp.base.BaseView

interface ComicsListContract {

    interface Presenter : BasePresenter<View> {
        fun setUpToolbar(view: android.view.View)
        fun loadComics(view: android.view.View)
    }

    interface View : BaseView {
        fun displayToolbar(toolbar: Toolbar)
        fun displayComics(recyclerView: RecyclerView)
    }
}