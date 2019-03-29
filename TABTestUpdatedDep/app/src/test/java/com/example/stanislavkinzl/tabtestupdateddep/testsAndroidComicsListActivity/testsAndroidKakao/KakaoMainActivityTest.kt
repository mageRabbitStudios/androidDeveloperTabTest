package com.example.stanislavkinzl.tabtestupdateddep.testsAndroidComicsListActivity.testsAndroidKakao

import com.example.libtestingandroid.parents.ActivityWithTestComponentTest
import com.example.stanislavkinzl.tabtestupdateddep.app.database.remote.ApiInterface
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.view.MainActivity
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroidComicsListActivity.MockSettings.EndpointJsons.GET_COMICS_EMPTY
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroidComicsListActivity.MockSettings.updateEndpointValue
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroidComicsListActivity.TestApp
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroidComicsListActivity.testsAndroidKakao.screens.KMainActivityTestScreen
import org.junit.Test
import org.robolectric.annotation.Config

@Config(application = TestApp::class)
class KakaoMainActivityTest : ActivityWithTestComponentTest(MainActivity::class.java) {

    val screen = KMainActivityTestScreen()

    @Test
    fun testMainScreenDisplayedCorrectly() {
        given ({}, launchFirst = true)

        screen {
            content {
                isVisible()
                isDisplayed()
            }
        }
    }

    @Test
    fun resultsAreDisplayed() {
        given ({}, launchFirst = true)

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
        given ({updateEndpointValue(ApiInterface.Endpoints.GET_COMICS, GET_COMICS_EMPTY)}, launchFirst = false)

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
        given ({}, launchFirst = true)

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