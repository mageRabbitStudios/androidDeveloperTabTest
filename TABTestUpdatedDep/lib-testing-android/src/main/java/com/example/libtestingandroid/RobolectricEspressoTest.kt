package com.example.libtestingandroid


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.*
import androidx.test.espresso.intent.Intents
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.libtestingandroid.helpers.RobolectricHelper
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith

/**This class is a parent class for all Robolectric 4.0+ tests. It was created in November 2018*/
@Suppress("DEPRECATION")
@RunWith(AndroidJUnit4::class)
abstract class RobolectricEspressoTest(givenActivity: Class<out Activity>) : BDDEspressoTest() {

    @get:Rule
    val activityRule = ActivityTestRule(givenActivity, false, false)

    protected open val screenLaunchIntent: Intent = Intent()

    /**In a project with a defined "Base" class for activities, it is a
     * good practise to set this as that class since then we can access its
     * members. Setting it as an Activity is also doable, also that would
     * reduce the implementation project('feature-base') in gradle*/
    private val activity: Activity by lazy {
        activityRule.activity
    }

    @CallSuper
    @Before
    open fun setup() {
        Intents.init()
    }

    @CallSuper
    @After
    open fun tearDown() {
        Intents.release()
    }

    private val targetContext: Context
        get() = InstrumentationRegistry.getInstrumentation().targetContext

    protected fun skip(milliseconds: Long) {
        RobolectricHelper.skip(milliseconds)
    }

    /**Call this method in every test execution when you wan't the activity to start*/
    protected fun given(step: () -> Unit, launchFirst: Boolean = true) {
        if (launchFirst) {
            activityRule.launchActivity(Intent())
        }
        step()
        if (!launchFirst) {
            activityRule.launchActivity(Intent())
        }
    }

    /////////////////////////////////////////////////////
    ///                                               ///
    ///               INTERNAL MATCHERS               ///
    ///(Matchers that require activity val or context)///
    ///                                               ///
    /////////////////////////////////////////////////////

    @RequiresApi(Build.VERSION_CODES.ECLAIR)
    fun iClickOnBackButton() {
        activity.onBackPressed()
    }

    /**Useful when you wan't to assure if tested view is part of the view hierarchy.*/
    @RequiresApi(Build.VERSION_CODES.ECLAIR)
    protected fun printViewHiearchy() {
        RobolectricHelper.printViewHierarchy(activity)
    }

    protected fun activityShouldBeFinished() {
        assertThat(activity.isFinishing).isTrue()
    }

    protected fun getResString(@StringRes id: Int): String {
        return targetContext.resources.getString(id)
    }

    protected fun getResInteger(@IntegerRes id: Int): Int {
        return targetContext.resources.getInteger(id)
    }

    @Suppress("DEPRECATION")
    protected fun getResColor(@ColorRes id: Int): Int {
        return targetContext.resources.getColor(id)
    }
}