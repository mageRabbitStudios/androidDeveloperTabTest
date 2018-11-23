package com.example.stanislavkinzl.tabtestupdateddep.injection

import android.app.Application
import android.content.Context
import com.example.stanislavkinzl.tabtestupdateddep.app.*
import com.example.stanislavkinzl.tabtestupdateddep.injection.modules.AMockNetworkModule
import dagger.Module
import dagger.Provides

@Module(includes = [AMockNetworkModule::class])//includes = [MockNetworkModule::class])
class ATestAppModule {

    @Provides
    internal fun provideContext(application: Application): Context = application

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = DefaultSchedulerProvider

    @Provides
    internal fun provideImageLoader(): ImageLoader = PicassoImageLoader()

    @Provides
    internal fun provideCalculator(context: Context): Calculator = Calculator(context)
}