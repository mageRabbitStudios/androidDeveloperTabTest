package com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.helpers

import androidx.core.widget.NestedScrollView
import android.view.View
import android.widget.FrameLayout
import android.widget.HorizontalScrollView
import android.widget.ScrollView
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ScrollToAction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.stanislavkinzl.tabtestupdateddep.R
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.helpers.RecyclerViewMatcher.Factory.withRecyclerView
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher

object TestMatchers {

    fun validateRecyclerViewItem(position: Int, stringToBeTestedOnTv: String, resIdOfRecyclerView: Int, resIdOfRowView: Int, resIdOfTextViewBeingAsserted: Int) {
        iScrollToItemInList(resIdOfRecyclerView, position)
        thenListItemIsDisplayed(resIdOfRecyclerView, position, resIdOfRowView)
        thenListItemHasText(resIdOfRecyclerView, position, resIdOfTextViewBeingAsserted, stringToBeTestedOnTv)
    }

    private fun scrollTo(): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return Matchers.allOf(
                    ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE),
                    ViewMatchers.isDescendantOfA(
                        Matchers.anyOf(
                            ViewMatchers.isAssignableFrom(ScrollView::class.java),
                            ViewMatchers.isAssignableFrom(HorizontalScrollView::class.java),
                            ViewMatchers.isAssignableFrom(NestedScrollView::class.java),
                            ViewMatchers.isAssignableFrom(RecyclerView::class.java),
                            ViewMatchers.isAssignableFrom(FrameLayout::class.java)
                        )
                    )
                )
            }

            override fun getDescription(): String {
                return "Scrolling to view"
            }

            override fun perform(uiController: UiController, view: View) {
                ScrollToAction().perform(uiController, view)
            }
        }
    }

    private fun withTotalItems(expectedItems: Int): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
            }

            override fun matchesSafely(view: View): Boolean {
                if (view !is RecyclerView) {
                    return false
                }

                return view.adapter?.itemCount == expectedItems
            }
        }
    }


    fun iScrollTo(id: Int) {
        onView(withId(id)).perform(scrollTo())
    }

    fun iScrollToItemInList(recyclerViewId: Int, position: Int) {
        onView(withId(recyclerViewId))
            .perform().perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(position))
    }

    fun thenIsDisplayed(id: Int) {
        iScrollTo(id)
        onView(withId(id)).check(matches(isDisplayed()))
    }

    fun thenListIsEmpty(recyclerViewId: Int) {
        thenListHasTotalItems(recyclerViewId, 0)
    }

    fun thenListHasTotalItems(recyclerViewId: Int, expectedTotalItems: Int) {
        onView(ViewMatchers.withId(recyclerViewId)).check(matches(withTotalItems(expectedTotalItems)))
    }

    fun thenListItemIsDisplayed(recyclerViewId: Int, position: Int, childViewId: Int) {
        onView(withRecyclerView(recyclerViewId)
                .atPositionOnView(position, childViewId))
            .perform(scrollTo())
            .check(matches(isDisplayed()))
    }

    fun thenListItemHasText(recyclerViewId: Int, position: Int, childViewId: Int, text: String) {
        onView(
            withRecyclerView(recyclerViewId)
                .atPositionOnView(position, childViewId)
        )
            .check(matches(ViewMatchers.withText(text)))
    }
}
