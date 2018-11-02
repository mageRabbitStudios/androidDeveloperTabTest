package com.igttestproject.stanislavkinzl.tabtest.app.dependencyinjection

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module//(includes = [NetworkModule::class])
class AppModule {

//    @Provides
//    @Singleton
//    internal fun provideApplication(): Application {
//        return app
//    }

    //    @Singleton
    @Provides
    internal fun provideContext(application: Application): Context {
        return application
    }

}
