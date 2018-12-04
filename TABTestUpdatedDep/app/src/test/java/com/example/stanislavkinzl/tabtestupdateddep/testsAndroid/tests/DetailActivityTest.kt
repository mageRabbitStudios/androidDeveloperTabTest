package com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.tests

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.libtestingandroid.RobolectricEspressoTest
import com.example.libtestingandroid.helpers.TestMatchers
import com.example.stanislavkinzl.tabtestupdateddep.R
import com.example.stanislavkinzl.tabtestupdateddep.feature.DetailActivity
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.TestApp
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(application = TestApp::class)
class DetailActivityTest : RobolectricEspressoTest(DetailActivity::class.java) {

    @Test
    fun testDetailScreenDisplayedCorrectly() {
        given ({}, launchFirst = true)

        TestMatchers.thenIsDisplayed(R.id.activity_detail_content)
    }

}