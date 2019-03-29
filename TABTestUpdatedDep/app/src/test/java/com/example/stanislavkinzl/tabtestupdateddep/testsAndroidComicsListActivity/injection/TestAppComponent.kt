package com.example.stanislavkinzl.tabtestupdateddep.testsAndroidComicsListActivity.injection

import android.app.Application
import com.example.stanislavkinzl.tabtestupdateddep.feature.ActivityBindings
import com.example.stanislavkinzl.tabtestupdateddep.feature.FragmentBindings
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.dependencyinjection.ComicListModule
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroidComicsListActivity.TestApp
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
        TestAppModule::class,
        ActivityBindings::class,
        FragmentBindings::class
    ]
)
interface TestAppComponent : AndroidInjector<DaggerApplication> {

    fun inject(testApp: TestApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): TestAppComponent
    }
}