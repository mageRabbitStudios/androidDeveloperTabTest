package com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist

import android.content.Context
import android.content.res.Configuration
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.TypedValue
import android.view.View
import com.igttestproject.stanislavkinzl.tabtest.NUMBER_OF_COMICS_PER_ROW_LANDSCAPE
import com.igttestproject.stanislavkinzl.tabtest.NUMBER_OF_COMICS_PER_ROW_PORTRAIT
import com.igttestproject.stanislavkinzl.tabtest.R
import com.igttestproject.stanislavkinzl.tabtest.common.GridSpacingItemDecoration

class ComicsListPresenter : ComicsListContract.Presenter {
    override fun fetchComics(view: View) {

    }

    override fun initRecyclerView(view: View) : RecyclerView {

        val recyclerView: RecyclerView = view.findViewById(R.id.rvComics)

        val spanCount: Int = when(context.resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> NUMBER_OF_COMICS_PER_ROW_PORTRAIT
            else -> NUMBER_OF_COMICS_PER_ROW_LANDSCAPE
        }

        val mLayoutManager = GridLayoutManager(context, spanCount)
        recyclerView.layoutManager = mLayoutManager

        recyclerView.addItemDecoration(GridSpacingItemDecoration(spanCount, dpToPx(10), true))
        recyclerView.itemAnimator = DefaultItemAnimator()

        return recyclerView
        // this.view.displayComics(recyclerView)

    }

    override fun setUpToolbar(view: View) {

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
                    collapsingToolbar.title = context.getString(R.string.app_name)
                    isShow = true
                } else if (isShow) {
                    collapsingToolbar.title = " "
                    isShow = false
                }
            }
        })
        this.view.displayToolbar(toolbar)
    }

    override fun onDetach() {

    }

    override fun attachView(view: ComicsListContract.View, context: Context) {
        this.view = view
        this.context = context
    }

    private lateinit var view: ComicsListContract.View
    private lateinit var context: Context

    /**
     * Converting dp to pixel
     */
    private fun dpToPx(dp: Int) = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), context.resources.displayMetrics))
}