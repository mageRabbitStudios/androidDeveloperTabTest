package com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.stanislavkinzl.tabtestupdateddep.app.App
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(application = App::class)
class MainActivityTest {
/*    @get:Rule
    val rule = ActivityTestRule(MainActivity::class.java)*/
   // lateinit var mainActivity: MainActivity

    @Before
    fun setUp() {

    }

    @Test
    fun testHelloWorldOnTextView() {
        /*Espresso.onView(ViewMatchers.withId(R.id.hello))
            .check(ViewAssertions.matches(ViewMatchers.withText("Hello World!")))*/
    }
}