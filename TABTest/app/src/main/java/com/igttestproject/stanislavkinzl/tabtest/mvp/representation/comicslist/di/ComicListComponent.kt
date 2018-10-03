package com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.di

import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.ComicsListFragment
import dagger.Subcomponent

@Subcomponent(modules = [(ComicListPresenterModule::class)])
interface ComicListComponent {
    fun inject(fragment: ComicsListFragment)
}
