package com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.widget.injection

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.igttestproject.stanislavkinzl.tabtest.app.ImageLoader
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.widget.ComicsListWidget
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.widget.ComicsListWidgetImpl
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.widget.adapter.ComicsListAdapter
import dagger.Module
import dagger.Provides

@Module
class ComicsListWidgetModule {

    @Provides
    fun provideComicsListWidget(comicsListWidget: ComicsListWidgetImpl): ComicsListWidget = comicsListWidget

    @Provides
    fun provideComicsListAdapter(context: Context, imageLoader: ImageLoader): ComicsListAdapter =
            ComicsListAdapter(context, imageLoader)

    @Provides
    fun provideLayoutManager(context: Context): RecyclerView.LayoutManager =
            LinearLayoutManager(context)
}