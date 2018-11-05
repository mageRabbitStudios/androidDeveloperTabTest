package com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.widget.toolbar

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
        this.toolbar = toolbar
    }
}