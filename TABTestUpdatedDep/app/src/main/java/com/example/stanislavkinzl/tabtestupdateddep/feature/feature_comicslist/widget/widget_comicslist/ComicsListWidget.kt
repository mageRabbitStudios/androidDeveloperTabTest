package com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.widget.widget_comicslist

import android.view.View
import com.example.stanislavkinzl.tabtestupdateddep.app.model.Comic

interface ComicsListWidget {


    fun init(view: View)

    fun addResults(memeList: List<Comic>)

}