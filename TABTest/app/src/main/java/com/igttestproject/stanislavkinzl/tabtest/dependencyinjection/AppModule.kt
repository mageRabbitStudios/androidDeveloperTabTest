package com.igttestproject.stanislavkinzl.tabtest.dependencyinjection

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {

    @Provides
    @Singleton
    internal fun provideApplication(): Application {
        return app
    }

    @Singleton
    @Provides
    internal fun provideContext(): Context {
        return app.applicationContext
    }

}
