package com.igttestproject.stanislavkinzl.tabtest.mvp.base

import android.content.Context

interface BasePresenter<V> {

    fun attachView(view: V, context: Context)

    fun onDetach()

}
