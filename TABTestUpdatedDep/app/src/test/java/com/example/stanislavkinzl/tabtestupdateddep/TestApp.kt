package com.example.stanislavkinzl.tabtestupdateddep


import com.example.stanislavkinzl.tabtestupdateddep.app.App
import com.example.stanislavkinzl.tabtestupdateddep.injection.DaggerTestAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


open class TestApp : App() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerTestAppComponent.builder().application(this).build()
    }
}