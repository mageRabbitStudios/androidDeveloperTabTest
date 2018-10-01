package com.igttestproject.stanislavkinzl.tabtest.dependencyinjection.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AndroidModule(private val application: Application) {

    //Singleton when it provides more objects
    @Provides
    fun provideApplicationContext(): Context = application
}