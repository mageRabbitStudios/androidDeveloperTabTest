package com.example.stanislavkinzl.tabtestupdateddep

import com.example.stanislavkinzl.tabtestupdateddep.app.App
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

open class TestMemeApp : App() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerTestAppComponent.builder().application(this).build()
    }
}