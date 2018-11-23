package com.example.stanislavkinzl.tabtestupdateddep.injection

import android.app.Application
import com.example.stanislavkinzl.tabtestupdateddep.ATestApp
import com.example.stanislavkinzl.tabtestupdateddep.MainActivityTest
import com.example.stanislavkinzl.tabtestupdateddep.app.dependencyinjection.ActivityBindings
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ATestAppModule::class,
        ActivityBindings::class
    ]
)
interface ATestAppComponent : AndroidInjector<DaggerApplication> {

    fun inject(testApp: ATestApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ATestAppComponent
    }
}