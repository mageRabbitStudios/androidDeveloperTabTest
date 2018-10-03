package com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.igttestproject.stanislavkinzl.tabtest.App
import com.igttestproject.stanislavkinzl.tabtest.mvp.base.BaseFragment
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.model.ComicOld
import es.dmoral.toasty.Toasty
import com.igttestproject.stanislavkinzl.tabtest.R
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.model.ComicsAdapter
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.di.ComicListPresenterModule
import kotlinx.android.synthetic.main.fragment_comics_list.*
import javax.inject.Inject



class ComicsListFragment : BaseFragment(), ComicsListContract.View {
    override fun initComicList(comicOldList: ArrayList<ComicOld>) {
        adapter = ComicsAdapter(context!!, comicOldList)
        gvComics.adapter = adapter
        Log.d("APP", "ComicOld List Adapter Int")
    }

    override fun showProof(proof: String) {
        Toasty.success(this.requireContext(), proof, Toast.LENGTH_LONG).show()
        Log.d("PROOF", "PROOF!")
    }

    override fun showComicList(comicOldList: ArrayList<ComicOld>) {
        adapter.setComicList(comicOldList)
        Log.d("APP", "ComicOld List Show")
    }

    @Inject
    lateinit var presenter: ComicsListPresenter

    private lateinit var adapter: ComicsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
          return inflater.inflate(R.layout.fragment_comics_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        injectComponents()

        presenter.attachView(this, context!!)
        presenter.proofOfMvp("proof!")
        presenter.initComicList()
        presenter.fetchComicList(true)
    }
}
