package com.example.stanislavkinzl.tabtestupdateddep

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

class AEspressoTestRunner : AndroidJUnitRunner() {
    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, ATestApp::class.java.name, context)
    }
}