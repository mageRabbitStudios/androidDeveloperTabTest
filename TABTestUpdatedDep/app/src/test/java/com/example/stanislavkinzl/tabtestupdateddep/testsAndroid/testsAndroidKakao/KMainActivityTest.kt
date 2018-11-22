package com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.testsAndroidKakao

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.libtestingandroid.ActivityBDDEspressoTest
import com.example.stanislavkinzl.tabtestupdateddep.app.database.remote.ApiInterface
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.view.MainActivity
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.TestApp
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.helpers.MockSettings.EndpointJsons.GET_COMICS_EMPTY
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.helpers.MockSettings.updateEndpointValue
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.testsAndroidKakao.screens.KMainActivityTestScreen
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

    val screen = KMainActivityTestScreen()

    @Before
    fun setUp() { activityRule = rule }


    @Test
    fun testMainScreenDisplayedCorrectly() {
        screen {
            content {
                isVisible()
                isDisplayed()
            }
        }
    }

    @Test
    fun resultsAreDisplayed() {
        screen {
            recycler_view {
                isVisible()
                childAt<KMainActivityTestScreen.Item>(0) {
                    isVisible()
                    title { hasText("Spiderman")}
                }

                lastChild<KMainActivityTestScreen.Item> {
                    isVisible()
                    title { hasText("Batman")}
                }
            }
        }
    }

    @Test
    fun emptyResultsAreDisplayed() {
       // Given ({ MockSettings.EndpointValues.GET_COMICS = GET_COMICS_EMPTY}, !launchFirst)
        Given ({updateEndpointValue(ApiInterface.Endpoints.GET_COMICS, GET_COMICS_EMPTY)}, launchFirst = true)

        screen {
            content  {
                isVisible()
            }
            recycler_view {
                isVisible()
                hasSize(0)
            }
        }
    }

    @Test
    fun firstItemGetsClicked() {
        screen {
            content { isVisible() }
            recycler_view {
                isVisible()
                firstChild<KMainActivityTestScreen.Item> {
                    isVisible()
                    click()
                }
            }
        }
    }
}