package com.example.stanislavkinzl.tabtestupdateddep.app.base

import android.os.Bundle
import android.view.View
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(provideLayout())
        initWidgets(findViewById(android.R.id.content))
        observeOnViewModels()
    }

    abstract fun provideLayout(): Int

    abstract fun observeOnViewModels()

    abstract fun initWidgets(view : View)
}