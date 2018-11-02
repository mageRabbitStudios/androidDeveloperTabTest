package com.igttestproject.stanislavkinzl.tabtest.proj.comicslist.viewModel

import android.arch.lifecycle.ViewModel

abstract class ComicsViewModel : ViewModel() {
    abstract fun fetchComicsList()
}