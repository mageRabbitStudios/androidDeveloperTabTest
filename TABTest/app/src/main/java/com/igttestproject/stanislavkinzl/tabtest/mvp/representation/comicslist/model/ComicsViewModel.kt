package com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel

abstract class ComicsViewModel : ViewModel() {

   /* sealed class State {
        data class FetchMemesSuccess(val memes: List<Meme>) : State()
        object FetchMemesError : State()
    }*/
/*

    abstract fun state(): LiveData<State>
*/

    abstract fun fetchComicsList()

}
