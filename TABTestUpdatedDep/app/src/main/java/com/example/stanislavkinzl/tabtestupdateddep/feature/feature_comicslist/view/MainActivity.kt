package com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.view

import androidx.lifecycle.Observer
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.stanislavkinzl.tabtestupdateddep.R
import com.example.stanislavkinzl.tabtestupdateddep.app.base.BaseActivity
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.viewmodel.ComicsViewModel
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.widget.widget_comicslist.ComicsListWidget
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.widget.widget_marveltoolbar.ToolbarWidget
import javax.inject.Inject

class MainActivity : BaseActivity() {

    //================= WIDGETS ===================

    @Inject
    lateinit var comicsViewModel: ComicsViewModel

    @Inject
    lateinit var comicsListWidget: ComicsListWidget

    @Inject
    lateinit var toolbarWidget: ToolbarWidget

    //=============================================

    override fun provideLayout(): Int = R.layout.activity_main

    override fun initWidgets(view: View) {
        comicsListWidget.init(view)
        toolbarWidget.init(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        comicsViewModel.getComicsApiList()
        toolbarWidget.setToolbar(this)
    }

    override fun provideViewModel() {
        comicsViewModel.state().observe(this, Observer {
            it?.let { onComicsViewModelStateChange(it) }
        })
    }

    private fun onComicsViewModelStateChange(state: ComicsViewModel.State) = when (state) {
        is ComicsViewModel.State.FetchMemesSuccess
        -> {
            comicsListWidget.addResults(state.comics)
            Toast.makeText(this, "Success loading comics", Toast.LENGTH_LONG).show()
        }
        is ComicsViewModel.State.FetchMemesError -> {
            Toast.makeText(this, "Error loading comics", Toast.LENGTH_LONG).show()
            System.out.println("Error")
        }
    }
}
