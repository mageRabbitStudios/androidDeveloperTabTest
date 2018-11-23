package com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.testsAndroidKakao

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.libtestingandroid.RobolectricEspressoTest
import com.example.stanislavkinzl.tabtestupdateddep.app.database.remote.ApiInterface
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.view.MainActivity
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.MockSettings.EndpointJsons.GET_COMICS_EMPTY
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.MockSettings.updateEndpointValue
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.TestApp
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.testsAndroidKakao.screens.KMainActivityTestScreen
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(application = TestApp::class)
class MainActivityTest : RobolectricEspressoTest(MainActivity()) {

    val screen = KMainActivityTestScreen()

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
        Given ({updateEndpointValue(ApiInterface.Endpoints.GET_COMICS, GET_COMICS_EMPTY)}, launchFirst = false)

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