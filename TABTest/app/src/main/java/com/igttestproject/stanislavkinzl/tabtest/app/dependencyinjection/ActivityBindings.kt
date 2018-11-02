package com.igttestproject.stanislavkinzl.tabtest.app.dependencyinjection

import com.igttestproject.stanislavkinzl.tabtest.proj.representation.MainActivity
import com.igttestproject.stanislavkinzl.tabtest.proj.representation.comicslist.di.ComicListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindings {

    @ContributesAndroidInjector(modules = [ComicListModule::class])
    abstract fun bindMainActivity(): MainActivity

}
