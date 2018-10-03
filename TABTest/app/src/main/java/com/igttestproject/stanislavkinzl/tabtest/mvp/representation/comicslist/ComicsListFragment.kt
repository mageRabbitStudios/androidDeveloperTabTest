package com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.igttestproject.stanislavkinzl.tabtest.App
import com.igttestproject.stanislavkinzl.tabtest.R
import com.igttestproject.stanislavkinzl.tabtest.mvp.base.BaseFragment
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.di.ComicListPresenterModule
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.model.ComicAdapter
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.model.ComicsViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject


class ComicsListFragment : BaseFragment(), ComicsListContract.View {

    override fun displayComics(recyclerView: RecyclerView) {
        this.rvComics = recyclerView
        adapter = ComicAdapter(context!!, ArrayList())
        this.rvComics.adapter = adapter
        subscribeToList()
    }

    override fun displayToolbar(toolbar: Toolbar) {
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
    }

    private lateinit var adapter: ComicAdapter
    private lateinit var progressBar: ProgressBar

    private val viewModel: ComicsViewModel by lazy { ViewModelProviders.of(this).get(ComicsViewModel::class.java) }

    @Inject
    lateinit var presenter: ComicsListPresenter

    override fun injectComponents() {
        (activity!!.application as App)
                .getAppComponent()!!
                .inject(ComicListPresenterModule(this))
                .inject(this)
    }

    private lateinit var rvComics: RecyclerView
    private var recyclerState: Parcelable? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_comics_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerState = savedInstanceState?.getParcelable("lmState")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("lmState", rvComics.layoutManager?.onSaveInstanceState())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        injectComponents()

        progressBar = view.findViewById(R.id.progressBar)
        progressBar.isActivated = true

        //presenter
        presenter.attachView(this, context!!)
        presenter.setUpToolbar(view)
        presenter.loadComics(view)
    }

    private fun subscribeToList() {
        viewModel.comicsList.observeOn(AndroidSchedulers.mainThread()).subscribe(
                { list ->
                    //this is where the loading into the adapter happens
                    adapter.comicsList = ArrayList(list)
                    adapter.notifyDataSetChanged()
                    progressBar.isActivated = false
                    progressBar.visibility = View.GONE
                    if (recyclerState != null) {
                        rvComics.layoutManager?.onRestoreInstanceState(recyclerState)
                        recyclerState = null
                    }
                },
                { e -> Log.e("NGVL", "Error", e) }
        )
    }
}
