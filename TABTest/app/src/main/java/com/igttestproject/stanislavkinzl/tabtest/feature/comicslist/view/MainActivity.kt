package com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.view

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.igttestproject.stanislavkinzl.tabtest.R
import com.igttestproject.stanislavkinzl.tabtest.app.base.BaseActivity
import com.igttestproject.stanislavkinzl.tabtest.app.model.Comic
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.viewmodel.ComicsViewModel
import es.dmoral.toasty.Toasty
import javax.inject.Inject

class MainActivity : BaseActivity() {

    override fun provideLayout(): Int = R.layout.activity_main

    override fun initWidgets(view: View) {}

    @Inject lateinit var comicsViewModel: ComicsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                   comicsViewModel.getComicsApiList()
    }

    override fun provideViewModel() {
        comicsViewModel.state().observe(this, Observer {
            it?.let { onComicsViewModelStateChange(it) }
        })
    }

    private fun onComicsViewModelStateChange(state: ComicsViewModel.State) = when (state) {

        is ComicsViewModel.State.FetchMemesSuccess
             -> {
                for (comic in state.comics) {
                    Toasty.success(this, comic.name, Toast.LENGTH_SHORT).show()
                    Log.i(comic.name, comic.url)
                }
            }

           ComicsViewModel.State.FetchMemesError
             -> Toasty.error(this, "Error loading comics", Toast.LENGTH_SHORT).show()
    }

    private fun logAllListedComics(comics: List<Comic>) {

    }

}
