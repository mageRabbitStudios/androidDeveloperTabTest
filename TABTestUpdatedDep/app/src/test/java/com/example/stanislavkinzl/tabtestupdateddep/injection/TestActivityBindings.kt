package com.example.stanislavkinzl.tabtestupdateddep.injection

import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.view.MainActivity
import com.example.stanislavkinzl.tabtestupdateddep.injection.modules.MockComicsListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TestActivityBindings {

    @ContributesAndroidInjector(modules = [MockComicsListModule::class])
    abstract fun bindMainActivity(): MainActivity

}
