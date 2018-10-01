package com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist

import android.util.Log

class ComicsListPresenter : ComicsListContract.Presenter {

    private var view: ComicsListContract.View? = null

    override fun onAttach(view: ComicsListContract.View) {
        this.view = view
    }

    override fun proofOfMvp(proof: String) {
        view?.showProof(proof)
        Log.d("It got here", "It got here")
    }

    override fun refreshComicList() {
    }

    override fun fetchComicList(showLoading: Boolean) {
    }

    override fun onDetach() {
    }

}