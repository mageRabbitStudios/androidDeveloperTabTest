package com.igttestproject.stanislavkinzl.tabtest.dependencyinjection

import com.igttestproject.stanislavkinzl.tabtest.MainActivity
import com.igttestproject.stanislavkinzl.tabtest.dependencyinjection.modules.AndroidModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidModule::class)]) //what kind of modules to use
interface ApplicationComponent {
    //what activities to inject
    fun inject(activity: MainActivity)
}