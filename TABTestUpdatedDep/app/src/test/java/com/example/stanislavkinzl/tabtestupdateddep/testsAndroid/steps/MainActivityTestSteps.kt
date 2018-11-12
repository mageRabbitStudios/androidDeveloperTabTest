package com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.steps

import com.example.stanislavkinzl.tabtestupdateddep.R
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.helpers.TestMatchers.iScrollToItemInList
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.helpers.TestMatchers.thenIsDisplayed
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.helpers.TestMatchers.thenListItemHasText
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.helpers.TestMatchers.thenListItemIsDisplayed
import com.example.stanislavkinzl.tabtestupdateddep.app.database.remote.ApiInterface.Endpoints.GET_COMICS
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.helpers.MockSettings.EndpointJsons.GET_COMICS_EMPTY
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.helpers.MockSettings.updateEndpointValue
import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.helpers.TestMatchers.thenListIsEmpty

object MainActivityTestSteps {

    //=================== STEPS ==============================

    fun iSeeMainScreen() {
        thenIsDisplayed(R.id.activity_main_content)
        System.out.println("I see main screen")
    }

    fun iSeeMockMemes() {
        validateMemeItem(0, "Meme 1")
        validateMemeItem(1, "Meme 2")
    }

    fun iSeeEmptyMemes() {
        thenListIsEmpty(R.id.rvComics)
    }

    fun theServerReturnsEmptyResponse() {
        updateEndpointValue(GET_COMICS, GET_COMICS_EMPTY)
    }

    //=================== ADDITIONAL FUNCTIONS ==============

    private fun validateMemeItem(position: Int, name: String) {
        iScrollToItemInList(R.id.rvComics, position)
        thenListItemIsDisplayed(R.id.rvComics, position, R.id.card_view)
        thenListItemHasText(R.id.rvComics, position, R.id.comics_list_item_title, name)
    }

}