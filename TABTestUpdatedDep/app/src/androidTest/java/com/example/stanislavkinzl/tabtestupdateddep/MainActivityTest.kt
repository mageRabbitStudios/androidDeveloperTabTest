package com.example.stanislavkinzl.tabtestupdateddep

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.libtestingandroid.EspressoTest
import com.example.stanislavkinzl.tabtestupdateddep.MainActivityTestSteps.iSeeEmptyListOfComics
import com.example.stanislavkinzl.tabtestupdateddep.MainActivityTestSteps.iSeeMainScreen
import com.example.stanislavkinzl.tabtestupdateddep.MainActivityTestSteps.iSeeMockMemes
import com.example.stanislavkinzl.tabtestupdateddep.MainActivityTestSteps.theServerReturnsEmptyResponse
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.view.MainActivity
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest : EspressoTest(MainActivity()) {

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