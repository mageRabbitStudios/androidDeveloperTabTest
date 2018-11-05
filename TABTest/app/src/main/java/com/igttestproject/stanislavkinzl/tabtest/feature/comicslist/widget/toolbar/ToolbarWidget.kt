package com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.widget.toolbar

import android.support.v7.widget.Toolbar
import android.view.View

interface ToolbarWidget {
    fun init(view: View)
    var toolbar: Toolbar
}