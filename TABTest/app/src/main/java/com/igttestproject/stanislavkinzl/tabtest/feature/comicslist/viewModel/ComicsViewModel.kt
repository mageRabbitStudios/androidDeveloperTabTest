package com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.viewModel

import android.arch.lifecycle.ViewModel

abstract class ComicsViewModel : ViewModel() {
    abstract fun fetchComicsList()
}