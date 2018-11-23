package com.example.libtestingandroid.helpers

import android.content.res.Resources
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

class RecyclerViewMatcher(private val recyclerViewId: Int) {

    companion object Factory {
        fun withRecyclerView(recyclerViewId: Int) =
            RecyclerViewMatcher(recyclerViewId)
    }

    fun atPosition(position: Int): Matcher<View> = atPositionOnView(position, -1)

    fun atPositionOnView(position: Int, targetViewId: Int): Matcher<View> =
        object : TypeSafeMatcher<View>() {
            var resources: Resources? = null
            var childView: View? = null

            override fun describeTo(description: Description) {

                val idDescription = resources?.run {
                    try {
                        getResourceName(recyclerViewId)
                    } catch (_: Resources.NotFoundException) {
                        String.format(
                            "%s (resource name not found)",
                            Integer.valueOf(recyclerViewId)
                        )
                    }
                } ?: Integer.toString(recyclerViewId)

                description.appendText("with id: $idDescription")
            }

            override fun matchesSafely(view: View): Boolean {
                this.resources = view.resources

                if (childView == null) {
                    val recyclerView =
                        view.rootView.findViewById(recyclerViewId) as RecyclerView

                    if (recyclerView.id != recyclerViewId) {
                        return false
                    }

                    childView = recyclerView.findViewHolderForAdapterPosition(position)?.itemView
                }

                if (targetViewId == -1) {
                    return view === childView
                }

                val targetView = childView?.findViewById(targetViewId) as View
                return view === targetView
            }
        }
}