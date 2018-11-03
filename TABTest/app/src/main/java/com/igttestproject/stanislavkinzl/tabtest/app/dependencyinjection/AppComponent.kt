package com.igttestproject.stanislavkinzl.tabtest.app.dependencyinjection

import android.app.Application
import com.igttestproject.stanislavkinzl.tabtest.app.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

//what kind of modules to use
@Component(modules = [AppModule::class, AndroidSupportInjectionModule::class, ActivityBindings::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}