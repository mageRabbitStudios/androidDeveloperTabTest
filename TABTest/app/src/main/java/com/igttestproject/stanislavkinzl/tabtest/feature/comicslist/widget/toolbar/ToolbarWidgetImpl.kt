package com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.widget.toolbar

import android.support.design.widget.AppBarLayout
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v7.widget.Toolbar
import android.view.View
import com.igttestproject.stanislavkinzl.tabtest.R
import kotlinx.android.extensions.LayoutContainer
import javax.inject.Inject

class ToolbarWidgetImpl @Inject constructor(
): ToolbarWidget, LayoutContainer {

    override lateinit var containerView: View

    override lateinit var toolbar: Toolbar

    override fun init(view: View) {
        containerView = view

        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
        val collapsingToolbar: CollapsingToolbarLayout = view.findViewById(R.id.collapsing_toolbar)
        collapsingToolbar.title = " "
        val appBarLayout: AppBarLayout = view.findViewById(R.id.appbar)
        appBarLayout.setExpanded(true)

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            var isShow = false
            var scrollRange = -1

            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.title = R.string.app_name.toString()
                    isShow = true
                } else if (isShow) {
                    collapsingToolbar.title = " "
                    isShow = false
                }
            }
        })

        this.toolbar = toolbar
    }


}