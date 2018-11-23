package com.example.stanislavkinzl.tabtestupdateddep


import com.example.stanislavkinzl.tabtestupdateddep.app.App
import com.example.stanislavkinzl.tabtestupdateddep.injection.DaggerATestAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


open class ATestApp : App() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerATestAppComponent.builder().application(this).build()
    }
}