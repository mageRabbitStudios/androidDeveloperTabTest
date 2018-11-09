package com.example.stanislavkinzl.tabtestupdateddep.app.dependencyinjection

import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.dependencyinjection.ComicListModule
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindings {

    @ContributesAndroidInjector(modules = [ComicListModule::class])
    abstract fun bindMainActivity(): MainActivity

}
