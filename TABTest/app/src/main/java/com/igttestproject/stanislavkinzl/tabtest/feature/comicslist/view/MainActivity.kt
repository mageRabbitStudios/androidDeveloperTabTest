package com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.view

import android.os.Bundle
import android.view.View
import com.igttestproject.stanislavkinzl.tabtest.R
import com.igttestproject.stanislavkinzl.tabtest.app.base.BaseActivity
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.viewModel.ComicsViewModel
import javax.inject.Inject

class MainActivity : BaseActivity() {

    override fun provideLayout(): Int = R.layout.activity_main

    override fun provideViewModel() {}

    override fun initWidgets(view: View) {}

    @Inject lateinit var viewModel: ComicsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchComicsList()
    }
}
