package com.igttestproject.stanislavkinzl.tabtest.mvp.representation

import android.os.Bundle
import android.view.View
import com.igttestproject.stanislavkinzl.tabtest.R
import com.igttestproject.stanislavkinzl.tabtest.mvp.base.BaseActivity
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.model.ComicsViewModel
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
