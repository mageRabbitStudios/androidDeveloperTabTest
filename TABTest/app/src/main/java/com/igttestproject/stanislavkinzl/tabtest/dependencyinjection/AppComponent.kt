package com.igttestproject.stanislavkinzl.tabtest.dependencyinjection

import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.di.ComicListComponent
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.di.ComicListPresenterModule
import dagger.Component


@Component(modules = [(AppModule::class)]) //what kind of modules to use
interface AppComponent {
    //what activities to inject

    fun inject(module: ComicListPresenterModule): ComicListComponent
}