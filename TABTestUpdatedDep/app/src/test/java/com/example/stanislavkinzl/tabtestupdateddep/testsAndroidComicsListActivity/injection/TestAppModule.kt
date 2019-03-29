package com.example.stanislavkinzl.tabtestupdateddep.testsAndroidComicsListActivity.injection

import android.app.Application
import android.content.Context
import com.example.stanislavkinzl.tabtestupdateddep.app.*
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroidComicsListActivity.injection.modules.MockNetworkModule
import dagger.Module
import dagger.Provides

@Module(includes = [MockNetworkModule::class])//includes = [MockNetworkModule::class])
class TestAppModule {

    @Provides
    internal fun provideContext(application: Application): Context = application

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = DefaultSchedulerProvider

    @Provides
    internal fun provideImageLoader(): ImageLoader = PicassoImageLoader()

    @Provides
    internal fun provideCalculator(context: Context): Calculator = Calculator(context)
}