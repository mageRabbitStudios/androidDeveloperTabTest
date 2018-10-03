package com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist

import android.content.Context
import android.util.Log
import com.igttestproject.stanislavkinzl.tabtest.R.drawable.*
import com.igttestproject.stanislavkinzl.tabtest.R.mipmap.ic_launcher
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.model.Comic

class ComicsListPresenter : ComicsListContract.Presenter {
    override fun initComicList() {
        view.initComicList(ArrayList<Comic>())
    }

    override fun attachView(view: ComicsListContract.View, context: Context) {
        this.view = view
        this.context = context
    }

    private lateinit var view: ComicsListContract.View
    private lateinit var context: Context

    override fun proofOfMvp(proof: String) {
        view.showProof(proof)
        Log.d("It got here", "It got here")
    }

    override fun fetchComicList(showLoading: Boolean) {
        var comicsList = ArrayList<Comic>()

        comicsList.add(Comic("Marvel", ic_launcher))
        comicsList.add(Comic("Spiderman",ic_launcher))
        comicsList.add(Comic("Bortuto", sample_0))
        comicsList.add(Comic("Naruto", sample_0))
        comicsList.add(Comic("Hulk", sample_0))

        view.showComicList(comicsList)
    }

    override fun onDetach() {
    }

}