package com.example.stanislavkinzl.tabtestupdateddep.app

import com.example.stanislavkinzl.tabtestupdateddep.app.dependencyinjection.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


open class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}

