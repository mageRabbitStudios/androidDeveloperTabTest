package com.example.stanislavkinzl.tabtestupdateddep.feature

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.stanislavkinzl.tabtestupdateddep.R
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.viewmodel.ComicsViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_example.*
import javax.inject.Inject

class ExampleComicListFragment : BaseFragment() {

    @Inject
    lateinit var comicsViewModel: ComicsViewModel

    override val layout: Int
        get() = R.layout.fragment_example

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AndroidSupportInjection.inject(this)
        observeOnViewModels()
    }

    private fun observeOnViewModels() {
        comicsViewModel.state().observe(this, Observer {
            it?.let { handleState(it) }
        })
    }

    private fun handleState(state: ComicsViewModel.State) = when (state) {
        is ComicsViewModel.State.FetchMemesSuccess -> comics_loaded_indicator.visibility = View.VISIBLE
        is ComicsViewModel.State.FetchMemesError -> comics_loaded_indicator.visibility = View.GONE
    }

}
