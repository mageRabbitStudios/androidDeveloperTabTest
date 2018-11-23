package com.example.stanislavkinzl.tabtestupdateddep

import com.example.stanislavkinzl.tabtestupdateddep.app.database.remote.ApiInterface.Endpoints.GET_COMICS
import com.example.stanislavkinzl.tabtestupdateddep.helpers.AMockSettings.EndpointJsons.GET_COMICS_EMPTY
import com.example.stanislavkinzl.tabtestupdateddep.helpers.AMockSettings.updateEndpointValue
import com.example.stanislavkinzl.tabtestupdateddep.helpers.ATestMatchers.thenIsDisplayed
import com.example.stanislavkinzl.tabtestupdateddep.helpers.ATestMatchers.thenListIsEmpty
import com.example.stanislavkinzl.tabtestupdateddep.helpers.ATestMatchers.validateRecyclerViewItem

object MainActivityTestSteps {

    //=================== STEPS ==============================

    fun iSeeMainScreen() {
        thenIsDisplayed(R.id.activity_main_content)
        System.out.println("I see main screen")
    }

    fun iSeeMockMemes() {
        validateRecyclerViewItem(1, "Batman", R.id.rvComics, R.id.card_view, R.id.comics_list_item_title)
        validateRecyclerViewItem(2, "Spiderman", R.id.rvComics, R.id.card_view, R.id.comics_list_item_title)
    }

    fun iSeeEmptyListOfComics() {
        thenListIsEmpty(R.id.rvComics)
    }

    fun theServerReturnsEmptyResponse() {
        updateEndpointValue(GET_COMICS, GET_COMICS_EMPTY)
    }

}