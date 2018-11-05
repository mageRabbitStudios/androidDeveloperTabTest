package com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.widget.comicslist

import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.igttestproject.stanislavkinzl.tabtest.app.common.GridSpacingItemDecoration
import com.igttestproject.stanislavkinzl.tabtest.app.model.Comic
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.widget.comicslist.adapter.ComicsListAdapter
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.widget_comics_list.*
import javax.inject.Inject

class ComicsListWidgetImpl @Inject constructor(
        private val comicsAdapter: ComicsListAdapter,
        private val gridLayoutManager: GridLayoutManager,
        private val itemDecoration: GridSpacingItemDecoration
) : ComicsListWidget, LayoutContainer {

    override lateinit var containerView: View

    override fun init(view: View) {

        containerView = view
        rvComics.layoutManager = gridLayoutManager
        rvComics.addItemDecoration(itemDecoration)
        rvComics.itemAnimator = DefaultItemAnimator()
        rvComics.adapter = comicsAdapter

    }

    override fun addResults(memeList: List<Comic>) {
        comicsAdapter.addResults(memeList)
    }
}