package com.igttestproject.stanislavkinzl.tabtest.mvp.representation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.igttestproject.stanislavkinzl.tabtest.R
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.ComicsListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var manager = supportFragmentManager
        var fragment = ComicsListFragment()
        manager.beginTransaction().replace(R.id.container,fragment).commit()


    }
}
