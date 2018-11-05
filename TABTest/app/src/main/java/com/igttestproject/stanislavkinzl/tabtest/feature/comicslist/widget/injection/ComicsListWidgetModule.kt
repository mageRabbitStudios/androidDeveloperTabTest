package com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.widget.injection

import android.content.Context
import android.content.res.Configuration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.igttestproject.stanislavkinzl.tabtest.app.Calculator
import com.igttestproject.stanislavkinzl.tabtest.app.ImageLoader
import com.igttestproject.stanislavkinzl.tabtest.app.NUMBER_OF_COMICS_PER_ROW_LANDSCAPE
import com.igttestproject.stanislavkinzl.tabtest.app.NUMBER_OF_COMICS_PER_ROW_PORTRAIT
import com.igttestproject.stanislavkinzl.tabtest.app.common.GridSpacingItemDecoration
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

   /* @Provides
    fun provideLayoutManager(context: Context): RecyclerView.LayoutManager =
            LinearLayoutManager(context)*/

    @Provides
    fun provideGridLayoutManager(context: Context, spanCount: Int): GridLayoutManager =
            GridLayoutManager(context, spanCount)

    @Provides
    fun provideSpanCount(context: Context): Int =
            when(context.resources.configuration.orientation) {

              Configuration.ORIENTATION_PORTRAIT -> NUMBER_OF_COMICS_PER_ROW_PORTRAIT
              else                               -> NUMBER_OF_COMICS_PER_ROW_LANDSCAPE
    }

    @Provides
    fun provideGridSpacingItemDecoration(calculator: Calculator, spanCount: Int): GridSpacingItemDecoration =
            GridSpacingItemDecoration(spanCount, calculator.dpToPx(10), true)
}