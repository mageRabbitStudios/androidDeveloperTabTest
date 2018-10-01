package com.igttestproject.stanislavkinzl.tabtest

import android.app.Application
import com.igttestproject.stanislavkinzl.tabtest.dependencyinjection.ApplicationComponent
import com.igttestproject.stanislavkinzl.tabtest.dependencyinjection.DaggerApplicationComponent
import com.igttestproject.stanislavkinzl.tabtest.dependencyinjection.modules.AndroidModule

class Application : Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent.builder()
                .androidModule(AndroidModule(this)).build()
    }
}