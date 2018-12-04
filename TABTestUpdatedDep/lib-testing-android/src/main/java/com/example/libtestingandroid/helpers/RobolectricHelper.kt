package com.example.libtestingandroid.helpers


import android.app.Activity
import android.content.res.Resources
import android.os.Build
import android.util.Pair
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.annotation.RequiresApi
import org.robolectric.Robolectric
import java.util.*
import java.util.concurrent.TimeUnit

/**For some useful utils for Robolectric check https://gist.github.com/OleksandrKucherenko*/
object RobolectricHelper {

    /** Print into log activity views hierarchy.  */
    @RequiresApi(Build.VERSION_CODES.ECLAIR)
    @NonNull
    fun printViewHierarchy(@NonNull activity: Activity) {
        printViewHierarchy(activity.findViewById<View>(android.R.id.content))
    }

    /** Print into log view hierarchy.  */
    @RequiresApi(Build.VERSION_CODES.ECLAIR)
    @NonNull
    fun printViewHierarchy(@NonNull root: View) {
        val output = StringBuilder(8192).append("\n")
        val r = root.resources
        val stack = Stack<Pair<String, View>>()
        stack.push(Pair.create("", root))

        while (!stack.empty()) {
            val pairedStack: Pair<String, View>? = stack.pop()
            val v = pairedStack!!.second

            val isLastOnLevel = stack.empty() || pairedStack.first != stack.peek().first
            val graphics = "" + pairedStack.first + if (isLastOnLevel) "└── " else "├── "

            val className = v.javaClass.simpleName
            val line = graphics + className + " id=" + v.id + resolveIdToName(r, v)

            output.append(line).append("\n")

            if (v is ViewGroup) {
                for (i in v.childCount - 1 downTo 0) {
                    stack.push(Pair.create(pairedStack.first + if (isLastOnLevel) "    " else "│   ", v.getChildAt(i)))
                }
            }
        }
        println(output)
    }

    /** @see [Lookup resource name](https://stackoverflow.com/questions/10137692/how-to-get-resource-name-from-resource-id)
     */
    @NonNull
    internal fun resolveIdToName(@Nullable r: Resources?, @NonNull v: View): String {
        if (null == r) return ""

        return try {
            " / " + r.getResourceEntryName(v.id)
        } catch (ignored: Throwable) {
            ""
        }
    }

    fun skip(milliseconds: Long) {
        Robolectric.getForegroundThreadScheduler().advanceBy(milliseconds, TimeUnit.MILLISECONDS)
        Robolectric.flushForegroundThreadScheduler()
    }
}