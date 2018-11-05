package com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.widget

import android.support.v7.widget.RecyclerView
import android.view.View
import com.igttestproject.stanislavkinzl.tabtest.app.model.Comic
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.widget.adapter.ComicsListAdapter
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.widget_comics_list.*
import javax.inject.Inject

class ComicsListWidgetImpl @Inject constructor(
        private val comicsAdapter: ComicsListAdapter,
        private val layoutManager: RecyclerView.LayoutManager
) : ComicsListWidget, LayoutContainer {

    override lateinit var containerView: View

    override fun init(view: View) {
        containerView = view
        rvComics.layoutManager = layoutManager
        rvComics.adapter = comicsAdapter
    }

    override fun addResults(memeList: List<Comic>) {

    }
}