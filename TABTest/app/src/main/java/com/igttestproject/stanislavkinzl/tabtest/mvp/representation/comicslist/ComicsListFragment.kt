package com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import com.igttestproject.stanislavkinzl.tabtest.R
import com.igttestproject.stanislavkinzl.tabtest.mvp.base.BaseFragment
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.Comic
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.model.ComicAdapter
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.model.ComicsViewModel
import es.dmoral.toasty.Toasty
import javax.inject.Inject


class ComicsListFragment : BaseFragment(), ComicsListContract.View {
    override fun onMemesFetched(comicsList: List<Comic>) {
        adapter.comicsList = ArrayList(comicsList)
        adapter.notifyDataSetChanged()
        progressBar.isActivated = false
        progressBar.visibility = View.GONE
        if (recyclerState != null) {
            rvComics.layoutManager?.onRestoreInstanceState(recyclerState)
            recyclerState = null
        }
    }

    override fun displayToolbar(toolbar: Toolbar) {
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
    }

    private lateinit var adapter: ComicAdapter
    private lateinit var progressBar: ProgressBar

    private lateinit var contextF: Context

    //   private val viewModel: ComicsViewModel by lazy { ViewModelProviders.of(this).get(ComicsViewModel::class.java) }

    @Inject
    lateinit var presenter: ComicsListPresenter

    @Inject
    lateinit var viewModel: ComicsViewModel

    override fun injectComponents() {
//        (activity!!.application as App)
//                .inject(ComicListPresenterModule())
//                .inject(this)
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
        contextF = view.context
        injectComponents()

        progressBar = view.findViewById(R.id.progressBar)
        progressBar.isActivated = true
//
//        //presenter
//        presenter.attachView(this, context!!)
//        presenter.setUpToolbar(view)
//        rvComics = presenter.initRecyclerView(view)

        //setting adapter
        //      adapter = ComicAdapter(context!!, ArrayList())
        //      this.rvComics.adapter = adapter

        //  presenter.fetchComics(view)
        // subscribeToList()
        //    observeViewModel()
                // viewModel.fetchComicList()
    }
/*
    private fun observeViewModel() {
        viewModel.getMemeLiveData().observe(this, Observer<ArrayList<Comic>> { memes ->
            if (memes != null) {
                adapter.comicsList = ArrayList(memes)
                adapter.notifyDataSetChanged()
                progressBar.isActivated = false
                progressBar.visibility = View.GONE
                if (recyclerState != null) {
                    rvComics.layoutManager?.onRestoreInstanceState(recyclerState)
                    recyclerState = null
                }
            } else {
                Toasty.error(contextF, "No results", Toast.LENGTH_LONG).show()
            }
        })
    }*/

    @SuppressLint("CheckResult")
    private fun subscribeToList() {
        /*  presenter.comicsList.observeOn(AndroidSchedulers.mainThread()).subscribe(
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
          )*/
    }
}
