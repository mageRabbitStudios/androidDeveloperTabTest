package com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.helpers


import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.test.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.TestApp
import org.junit.Rule

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

    /*//TODO: Is this lax solution ? Maybe it could be done better?
    lateinit var activityRule: ActivityTestRule<T>*/

//    abstract val clazz: Class<T>



   /* @JvmField
    @Rule
    var activityRule: ClearedPrefsActivityTestRuxle<out T> = ClearedPrefsActivityTestRule(clazz,
        false,
        false)

    protected val application: TestApp by lazy {
        InstrumentationRegistry.getTargetContext().applicationContext as TestApp
    }

    protected val activity: Activity by lazy {
        activityRule.activity
    }

    protected val targetContext: Context
        get() = InstrumentationRegistry.getTargetContext()*/

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