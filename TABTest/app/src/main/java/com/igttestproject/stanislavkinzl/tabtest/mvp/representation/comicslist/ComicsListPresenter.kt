package com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist

import android.content.Context
import android.util.Log
import com.igttestproject.stanislavkinzl.tabtest.R.drawable.*
import com.igttestproject.stanislavkinzl.tabtest.R.mipmap.ic_launcher

class ComicsListPresenter : ComicsListContract.Presenter {
    override fun onDetach() {

    }
    /* override fun initComicList() {
         view.initComicList(ArrayList<ComicOld>())
     }*/

    override fun attachView(view: ComicsListContract.View, context: Context) {
        this.view = view
        this.context = context
    }

    private lateinit var view: ComicsListContract.View
    private lateinit var context: Context

    override fun proofOfMvp(proof: String) {
        view.showProof(proof)
    }

   /* override fun fetchComicList(showLoading: Boolean) {
        var comicsList = ArrayList<ComicOld>()

        comicsList.add(ComicOld("Marvel", ic_launcher))
        comicsList.add(ComicOld("Spiderman",ic_launcher))
        comicsList.add(ComicOld("Bortuto", sample_0))
        comicsList.add(ComicOld("Naruto", sample_0))
        comicsList.add(ComicOld("Hulk", sample_0))

        view.showComicList(comicsList)*/
}