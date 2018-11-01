package com.igttestproject.stanislavkinzl.tabtest.dependencyinjection

import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.di.ComicListComponent
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.di.ComicListPresenterModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

//what kind of modules to use
@Component(modules = [AppModule::class, AndroidSupportInjectionModule::class]) interface AppComponent {

    //what VIEWS to inject
    fun inject(module: ComicListPresenterModule): ComicListComponent
}