package com.igttestproject.stanislavkinzl.tabtest

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import com.igttestproject.stanislavkinzl.tabtest.dependencyinjection.component
import com.igttestproject.stanislavkinzl.tabtest.presenter.MainActivityPresenter
import com.igttestproject.stanislavkinzl.tabtest.repository.database.DatabaseComicsRepository
import com.igttestproject.stanislavkinzl.tabtest.view.IMainActivityView
import es.dmoral.toasty.Toasty
import javax.inject.Inject

class MainActivity : AppCompatActivity(), IMainActivityView {

    //injections
    @Inject
    private lateinit var context: Context

    @SuppressLint("SetTextI18n")
    override fun displayProof(response: String) {
        Toasty.success(this, response, Toast.LENGTH_SHORT).show()
        val textView: TextView = findViewById(R.id.tv)
        textView.text = response + context.toString()
    }


    private lateinit var presenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component().inject(this)

        presenter = MainActivityPresenter(this, DatabaseComicsRepository())
        presenter.loadComics()
    }
}
