package com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.igttestproject.stanislavkinzl.tabtest.App
import com.igttestproject.stanislavkinzl.tabtest.mvp.base.BaseFragment
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.model.Comic
import es.dmoral.toasty.Toasty
import com.igttestproject.stanislavkinzl.tabtest.R
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.di.ComicListPresenterModule
import javax.inject.Inject



class ComicsListFragment : BaseFragment(), ComicsListContract.View {

    override fun showProof(proof: String) {
        Toasty.success(this.requireContext(), proof, Toast.LENGTH_LONG).show()
        Log.d("PROOF", "PROOF!")
    }

    override fun showComicList(comicList: List<Comic>) {

    }

    @Inject
    lateinit var presenter: ComicsListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (activity!!.application as App)
                .getAppComponent()!!
                .inject(ComicListPresenterModule(this))
                .inject(this)

        presenter.onAttach(this)
        presenter.proofOfMvp("proof!")
    }

    companion object {
        fun newInstance(): ComicsListFragment {
            return ComicsListFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      //  Toasty.success(this.context!!.applicationContext, "OHohoho!", Toast.LENGTH_LONG).show()

    //    val activity = activity
    //    val recyclerView = view!!.findViewById(R.id.comic_list) as RecyclerView
    //    recyclerView.layoutManager = GridLayoutManager(activity, 2)
       // recyclerView.adapter = RageComicAdapter(activity)

        return inflater.inflate(R.layout.fragment_comics_list, container, false)
    }

}
