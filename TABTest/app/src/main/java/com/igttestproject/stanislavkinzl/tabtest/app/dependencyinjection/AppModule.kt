package com.igttestproject.stanislavkinzl.tabtest.app.dependencyinjection

import android.app.Application
import android.content.Context
import com.igttestproject.stanislavkinzl.tabtest.app.database.remote.dependencyinjection.NetworkModule
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class])
class AppModule {

    @Provides
    internal fun provideContext(application: Application): Context {
        return application
    }

}
