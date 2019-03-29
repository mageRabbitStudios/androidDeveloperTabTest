package com.example.stanislavkinzl.tabtestupdateddep.feature

import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.dependencyinjection.ComicListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindings {

    @ContributesAndroidInjector(modules = [ComicListFragmentModule::class])
    abstract fun bindExampleFragment(): ExampleComicListFragment

}