package com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.widget

import android.view.View
import com.igttestproject.stanislavkinzl.tabtest.app.model.Comic

interface ComicsListWidget {


    fun init(view: View)

    fun addResults(memeList: List<Comic>)

}