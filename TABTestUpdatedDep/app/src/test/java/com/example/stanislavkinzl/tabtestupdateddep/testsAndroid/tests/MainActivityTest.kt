package com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.tests

import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.view.MainActivity
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.TestApp
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.helpers.ActivityBDDEspressoTest
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.steps.MainActivityTestSteps.iSeeEmptyMemes
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.steps.MainActivityTestSteps.iSeeMainScreen
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.steps.MainActivityTestSteps.iSeeMockMemes
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.steps.MainActivityTestSteps.theServerReturnsEmptyResponse
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config


@Suppress("DEPRECATION")
@RunWith(AndroidJUnit4::class) //robolectric runs on this too
@Config(application = TestApp::class) //this links the test with test dagger
class MainActivityTest : ActivityBDDEspressoTest<MainActivity>() { //extension
    //links the test with steps, helpers etc.

    //This builds the activity
    @get:Rule
    val rule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() { activityRule = rule } //this passes our activity(rule) to our activityRule in BDDEspressoTest

    @Test
    fun testMainScreenDisplayedCorrectly() {
        Given { iSeeMainScreen() }
    }

    @Test
    fun resultsAreDisplayed() {
        Given { iSeeMainScreen() }
        Then  { iSeeMockMemes() }
    }

    @Test
    fun emptyResultsAreDisplayed() {
        Given({ theServerReturnsEmptyResponse() }, !launchFirst)
        When { iSeeMainScreen() }
        Then { iSeeEmptyMemes() }
    }
}