package com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.helpers


import android.app.Activity
import android.content.Intent
import androidx.test.rule.ActivityTestRule

abstract class BDDEspressoTest {

    fun Given(step: () -> Unit) {
        step()
    }

    fun When(step: () -> Unit) {
        step()
    }

    fun Then(step: () -> Unit) {
        step()
    }

    fun And(step: () -> Unit) {
        step()
    }
}

abstract class ActivityBDDEspressoTest <T : Activity> : BDDEspressoTest() {

    //TODO: Is this lax solution ? Maybe it could be done better?
    lateinit var activityRule: ActivityTestRule<T>
    val launchFirst = true

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