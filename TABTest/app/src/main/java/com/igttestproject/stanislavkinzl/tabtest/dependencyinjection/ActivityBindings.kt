package com.igttestproject.stanislavkinzl.tabtest.dependencyinjection

import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.MainActivity
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.di.ComicListPresenterModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindings {

    @ContributesAndroidInjector(modules = [ComicListPresenterModule::class])
    abstract fun bindMainActivity(): MainActivity

}
