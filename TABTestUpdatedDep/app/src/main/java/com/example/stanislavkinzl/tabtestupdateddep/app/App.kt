package com.example.stanislavkinzl.tabtestupdateddep.app

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import com.example.stanislavkinzl.tabtestupdateddep.app.dependencyinjection.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/*
open class App : Application(), HasActivityInjector {

    @Inject
    open lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).build().inject(this)
    }


    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }
}
*/



open class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}

