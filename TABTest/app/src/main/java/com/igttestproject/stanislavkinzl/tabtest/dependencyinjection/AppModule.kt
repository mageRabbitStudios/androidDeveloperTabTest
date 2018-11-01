package com.igttestproject.stanislavkinzl.tabtest.dependencyinjection

import android.app.Application
import android.content.Context
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.NetworkModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
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
