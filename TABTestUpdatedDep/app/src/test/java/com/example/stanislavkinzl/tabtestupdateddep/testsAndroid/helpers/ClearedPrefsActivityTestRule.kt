package com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.helpers

import android.app.Activity
import android.content.Intent
import android.preference.PreferenceManager
import androidx.test.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.intercepting.SingleActivityFactory

@Suppress("DEPRECATION")
class ClearedPrefsActivityTestRule<T : Activity> : ActivityTestRule<T> {

    private var restarting = false

    constructor(activityClass: Class<T>?) : super(activityClass)

    constructor(activityClass: Class<T>?, initialTouchMode: Boolean) :
            super(activityClass, initialTouchMode)

    constructor(activityClass: Class<T>?, initialTouchMode: Boolean, launchActivity: Boolean) :
            super(activityClass, initialTouchMode, launchActivity)

    constructor(activityFactory: SingleActivityFactory<T>, initialTouchMode: Boolean, launchActivity: Boolean) :
            super(activityFactory, initialTouchMode, launchActivity)

    override fun beforeActivityLaunched() {
        super.beforeActivityLaunched()

        if (!restarting) {
            val prefs = PreferenceManager
                .getDefaultSharedPreferences(InstrumentationRegistry.getTargetContext())
            prefs.edit().clear().apply()

            restarting = false
        }
    }

    override fun afterActivityFinished() {
        super.afterActivityFinished()

        if (restarting) {
            launchActivity(Intent())
        }
    }

    fun restartActivity() {
        restarting = true
        finishActivity()
    }

    fun getString(stringResId: Int): String = activity.getString(stringResId)
}