package com.igttestproject.stanislavkinzl.tabtest.app.dependencyinjection

import android.app.Application
import android.content.Context
import com.igttestproject.stanislavkinzl.tabtest.app.DefaultSchedulerProvider
import com.igttestproject.stanislavkinzl.tabtest.app.ImageLoader
import com.igttestproject.stanislavkinzl.tabtest.app.PicassoImageLoader
import com.igttestproject.stanislavkinzl.tabtest.app.SchedulerProvider
import com.igttestproject.stanislavkinzl.tabtest.app.database.remote.dependencyinjection.NetworkModule
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class])
class AppModule {

    @Provides
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = DefaultSchedulerProvider


    @Provides
    internal fun provideImageLoader(): ImageLoader = PicassoImageLoader()

}