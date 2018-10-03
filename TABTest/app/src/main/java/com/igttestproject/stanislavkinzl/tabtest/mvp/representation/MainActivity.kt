package com.igttestproject.stanislavkinzl.tabtest.mvp.representation

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import com.igttestproject.stanislavkinzl.tabtest.R
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.entity.Comic
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.ComicsListFragment
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.model.ComicAdapter
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.model.ComicsViewModel
import io.reactivex.android.schedulers.AndroidSchedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = supportFragmentManager
        val fragment = ComicsListFragment()
        manager.beginTransaction().replace(R.id.container,fragment).commit()
    }
}
