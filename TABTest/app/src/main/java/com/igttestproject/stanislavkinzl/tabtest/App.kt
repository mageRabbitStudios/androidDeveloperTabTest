package com.igttestproject.stanislavkinzl.tabtest

import android.app.Application
import com.igttestproject.stanislavkinzl.tabtest.dependencyinjection.AppComponent
import com.igttestproject.stanislavkinzl.tabtest.dependencyinjection.AppModule
import com.igttestproject.stanislavkinzl.tabtest.dependencyinjection.DaggerAppComponent

class App : Application() {

    private var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()

        buildAppComponent()

        // init realm
      //  RealmHelper.init(this)
    }

    private fun buildAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    fun getAppComponent(): AppComponent? {
        return appComponent
    }
}