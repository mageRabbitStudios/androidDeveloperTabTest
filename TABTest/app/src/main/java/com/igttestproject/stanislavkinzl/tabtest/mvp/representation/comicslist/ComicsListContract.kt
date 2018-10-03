package com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist

import com.igttestproject.stanislavkinzl.tabtest.mvp.base.BasePresenter
import com.igttestproject.stanislavkinzl.tabtest.mvp.base.BaseView

interface ComicsListContract {

    interface Presenter : BasePresenter<View> {
        fun proofOfMvp(proof: String)

    }

    interface View : BaseView {
        fun showProof(proof: String)
    }
}