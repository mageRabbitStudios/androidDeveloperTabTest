package com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.testsAndroidKakao.screens

import android.view.View
import com.agoda.kakao.*
import com.example.stanislavkinzl.tabtestupdateddep.R
import org.hamcrest.Matcher

open class KMainActivityTestScreen : Screen<KMainActivityTestScreen>() {
    val content: KView = KView { withId(R.id.activity_main_content) }
    val recycler_view: KRecyclerView = KRecyclerView(
        { withId(R.id.rvComics) },
        { itemType(::Item) }
    )

    class Item(parent: Matcher<View>) : KRecyclerItem<Item>(parent) {
        val title: KTextView = KTextView(parent)
         { withId(R.id.comics_list_item_title) }
        val pageCount: KTextView = KTextView(parent)
         { withId(R.id.comics_list_item_count) }
    }
}