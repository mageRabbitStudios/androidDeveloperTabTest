package com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist

import android.arch.lifecycle.ViewModelProviders
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.igttestproject.stanislavkinzl.tabtest.App
import com.igttestproject.stanislavkinzl.tabtest.R
import com.igttestproject.stanislavkinzl.tabtest.mvp.base.BaseFragment
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.entity.Comic
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.model.ComicAdapter
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.model.ComicsViewModel
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.di.ComicListPresenterModule
import es.dmoral.toasty.Toasty
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CollapsingToolbarLayout
import android.util.TypedValue
import android.support.v7.widget.DefaultItemAnimator
import com.igttestproject.stanislavkinzl.tabtest.common.GridSpacingItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.widget.ProgressBar
import com.igttestproject.stanislavkinzl.tabtest.NUMBER_OF_COMICS_PER_ROW_LANDSCAPE
import com.igttestproject.stanislavkinzl.tabtest.NUMBER_OF_COMICS_PER_ROW_PORTRAIT


class ComicsListFragment : BaseFragment(), ComicsListContract.View {

    override fun showProof(proof: String) {
        Toasty.success(this.requireContext(), proof, Toast.LENGTH_LONG).show()
        Log.d("PROOF", "PROOF!")
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

    companion object {
        fun newInstance(): ComicsListFragment {
            return ComicsListFragment()
        }
    }

    private lateinit var rvComics: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_comics_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        injectComponents()
        //toolbar stuff
        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        val collapsingToolbar: CollapsingToolbarLayout = view.findViewById(R.id.collapsing_toolbar)
        collapsingToolbar.title = " "
        val appBarLayout: AppBarLayout = view.findViewById(R.id.appbar)
        appBarLayout.setExpanded(true)

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            var isShow = false
            var scrollRange = -1

            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.title = getString(R.string.app_name)
                    isShow = true
                } else if (isShow) {
                    collapsingToolbar.title = " "
                    isShow = false
                }
            }
        })

        progressBar = view.findViewById(R.id.progressBar)
        progressBar.isActivated = true

        //initing adapter, presenter, rv
        val emptyList: ArrayList<Comic> = ArrayList<Comic>()
        adapter = ComicAdapter(context!!, emptyList)

        presenter.attachView(this, context!!)
        presenter.proofOfMvp("proof!")


        rvComics = view.findViewById(R.id.rvComics)

        val spanCount: Int = when(this.resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> NUMBER_OF_COMICS_PER_ROW_PORTRAIT
            else -> NUMBER_OF_COMICS_PER_ROW_LANDSCAPE
        }

        val mLayoutManager = GridLayoutManager(context!!, spanCount)
        rvComics.layoutManager = mLayoutManager

        //making recyclerView two row
        rvComics.addItemDecoration(GridSpacingItemDecoration(spanCount, dpToPx(10), true))
        rvComics.itemAnimator = DefaultItemAnimator()

        rvComics.adapter = adapter

        subscribeToList()
    }

    private fun subscribeToList() {
        val disposable = viewModel.comicsList
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { list ->
                            adapter.comicsList = ArrayList(list)
                            adapter.notifyDataSetChanged()
                            progressBar.isActivated = false
                            progressBar.visibility = View.GONE
                        },
                        { e ->
                            Log.e("NGVL", "Error", e)
                        }
                )
    }


    /**
     * Converting dp to pixel
     */
    private fun dpToPx(dp: Int) = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), resources.displayMetrics))

}
