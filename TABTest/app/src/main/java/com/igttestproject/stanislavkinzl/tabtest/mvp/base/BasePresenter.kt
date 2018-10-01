package com.igttestproject.stanislavkinzl.tabtest.mvp.base

interface BasePresenter<V> {

    fun onAttach(view: V)

    fun onDetach()

}
