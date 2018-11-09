package com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.tests

import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.view.MainActivity
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.TestApp
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Suppress("DEPRECATION")
@RunWith(AndroidJUnit4::class)
@Config(application = TestApp::class)
class MainActivityTest {

    @get:Rule
    val rule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {

    }

    @Test
    fun testHelloWorldOnTextView() {

    }
}