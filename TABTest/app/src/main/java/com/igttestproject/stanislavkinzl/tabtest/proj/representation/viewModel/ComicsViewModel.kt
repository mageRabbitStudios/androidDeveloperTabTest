package com.igttestproject.stanislavkinzl.tabtest.proj.representation.viewModel

import android.arch.lifecycle.ViewModel

abstract class ComicsViewModel : ViewModel() {
    abstract fun fetchComicsList()
}