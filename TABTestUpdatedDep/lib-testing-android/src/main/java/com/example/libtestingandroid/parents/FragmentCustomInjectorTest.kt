package com.example.libtestingandroid.parents


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.CallSuper
import androidx.annotation.ColorRes
import androidx.annotation.IntegerRes
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.test.espresso.intent.Intents
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.example.libtestingandroid.BDDEspressoTest
import com.example.libtestingandroid.ClearedPrefsActivityTestRule
import com.example.libtestingandroid.FragmentTestActivity
import com.example.libtestingandroid.R
import com.example.libtestingandroid.helpers.RobolectricHelper
import org.assertj.core.api.Assertions
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations

/**Parent for all instrumented tests*/
// TODO: Address Deprecation and UncheckedCast
@Suppress("DEPRECATION")
@RunWith(AndroidJUnit4::class)
abstract class FragmentCustomInjectorTest <FRAGMENT : Fragment> (private val fragment: Fragment) : BDDEspressoTest() {

    // =====================================================
    //                       RULES                        //
    // =====================================================

    @get:Rule
    var activityRule: ClearedPrefsActivityTestRule<out FragmentTestActivity> =
        ClearedPrefsActivityTestRule(
            FragmentTestActivity::class.java,
            initialTouchMode = false,
            launchActivity = false
        )

    // TODO: Add "ruleChain" and "globalTimeout" rules if needed in the future. Deleted since it was giving the error: "You should only call this from the main thread!"

    // =====================================================
    //                 VARIABLES/VALUES                   //
    // =====================================================

    private val activity: Activity by lazy {
        activityRule.activity
    }

    private val targetContext: Context
        get() = InstrumentationRegistry.getInstrumentation().targetContext

    abstract var injection: (FRAGMENT) -> Unit

    // =====================================================
    //                       SUPERS                       //
    // =====================================================

    @CallSuper
    @Before
    open fun setup() {
        Intents.init()
//        InstrumentationRegistry.getInstrumentation().targetContext.applicationContext.setTheme(R.style.Theme_AppCompat)
        MockitoAnnotations.initMocks(this)
    }

    @CallSuper
    @After
    open fun tearDown() {
        Intents.release()
    }

    // =====================================================
    //                       OTHER                        //
    // =====================================================

    /**Call this method in every test execution when you wan't the activity to start*/
    private fun launchActivity(
        step: () -> Unit,
        launchFirst: Boolean = true,
        injector: (FRAGMENT) -> Unit,
        intent: Intent? = null  // if we wan't to mock intent
    ) {
        if (launchFirst) {
            activityRule.launchActivity(intent ?: Intent())
            activityRule.activity.startFragment(fragment, injector)
        }
        step()
        if (!launchFirst) {
            activityRule.launchActivity(intent ?: Intent())
            activityRule.activity.startFragment(fragment, injector)
        }
    }

    protected fun activityShouldBeFinished() {
        Assertions.assertThat(activity.isFinishing).isTrue()
    }

    protected fun getResString(@StringRes id: Int): String {
        return targetContext.resources.getString(id)
    }

    protected fun getResInteger(@IntegerRes id: Int): Int {
        return targetContext.resources.getInteger(id)
    }

    protected fun getResColor(@ColorRes id: Int): Int {
        return targetContext.resources.getColor(id)
    }

    protected fun givenFragmentHasBeenLaunched(injector: (FRAGMENT) -> Unit) {
        launchActivity({ }, launchFirst = true, injector = injector)
    }

    protected fun givenFragmentHasBeenLaunched(intent: Intent, injector: (FRAGMENT) -> Unit) {
        launchActivity({ }, launchFirst = true, intent = intent, injector = injector)
    }

    protected fun givenThisHappenedBeforeFragmentLaunch(task: () -> Unit, injector: (FRAGMENT) -> Unit) {
        launchActivity({ task() }, launchFirst = false, injector = injector)
    }

    protected fun givenThisHappenedBeforeFragmentLaunch(
        task: () -> Unit,
        intent: Intent,
        injector: (FRAGMENT) -> Unit
    ) {
        launchActivity({ task() }, launchFirst = false, intent = intent, injector = injector)
    }

    /**Useful when you wan't to assure if tested view is part of the view hierarchy.*/
    @RequiresApi(Build.VERSION_CODES.ECLAIR)
    protected fun printViewHierarchy() {
        RobolectricHelper.printViewHierarchy(activity)
    }

}