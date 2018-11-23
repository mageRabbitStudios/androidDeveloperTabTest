package com.example.libtestingandroid


import android.app.Activity
import android.content.Intent
import androidx.test.rule.ActivityTestRule
import org.junit.Rule


abstract class RobolectricEspressoTest (activity: Activity) : BDDEspressoTest() {

    @get:Rule
    val activityRule = ActivityTestRule(activity::class.java)

    fun Given(step: () -> Unit, launchFirst: Boolean = true) {
        if (launchFirst) {
            activityRule.launchActivity(Intent())
        }
        step()
        if (!launchFirst) {
            activityRule.launchActivity(Intent())
        }
    }
}