package com.example.stanislavkinzl.tabtestupdateddep.app.dependencyinjection

import android.app.Application
import com.example.stanislavkinzl.tabtestupdateddep.app.App
import com.example.stanislavkinzl.tabtestupdateddep.feature.ActivityBindings
import com.example.stanislavkinzl.tabtestupdateddep.feature.FragmentBindings
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.dependencyinjection.ComicListModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication

//what kind of modules to use
@Component(modules = [
    AppModule::class,
    AndroidSupportInjectionModule::class,
    ActivityBindings::class,
    FragmentBindings::class
])
interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}