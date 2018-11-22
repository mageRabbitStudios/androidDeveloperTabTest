package com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.tests

import androidx.test.rule.ActivityTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.view.MainActivity
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.TestApp
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.helpers.ActivityBDDEspressoTest
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.steps.MainActivityTestSteps.iSeeEmptyListOfComics
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.steps.MainActivityTestSteps.iSeeMainScreen
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.steps.MainActivityTestSteps.iSeeMockMemes
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.steps.MainActivityTestSteps.theServerReturnsEmptyResponse
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config


@RunWith(AndroidJUnit4::class)
@Config(application = TestApp::class)
class MainActivityTest : ActivityBDDEspressoTest<MainActivity>() {

    @get:Rule
    val rule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() { activityRule = rule }

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
        Given({ theServerReturnsEmptyResponse() }, launchFirst = false)
        When { iSeeMainScreen() }
        Then { iSeeEmptyListOfComics() }
    }
}