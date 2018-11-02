package com.igttestproject.stanislavkinzl.tabtest.app.dependencyinjection

import com.igttestproject.stanislavkinzl.tabtest.proj.comicslist.view.MainActivity
import com.igttestproject.stanislavkinzl.tabtest.proj.comicslist.modules.ComicListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindings {

    @ContributesAndroidInjector(modules = [ComicListModule::class])
    abstract fun bindMainActivity(): MainActivity

}
