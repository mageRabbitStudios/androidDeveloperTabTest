package com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
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


class ComicsListFragment : BaseFragment(), ComicsListContract.View {
 /*   override fun initComicList(comicOldList: ArrayList<ComicOld>) {
        /*   adapter = ComicsAdapter(context!!, comicOldList)
           gvComics.adapter = adapter
           Log.d("APP", "ComicOld List Adapter Int")*/
    }*/

    override fun showProof(proof: String) {
        Toasty.success(this.requireContext(), proof, Toast.LENGTH_LONG).show()
        Log.d("PROOF", "PROOF!")
    }

/*    override fun showComicList(comicOldList: ArrayList<ComicOld>) {
        //    adapter.setComicList(comicOldList)
        //    Log.d("APP", "ComicOld List Show")
    }*/

    private lateinit var adapter: ComicAdapter

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

        val emptyList: ArrayList<Comic> = ArrayList<Comic>()
        adapter = ComicAdapter(context!!, emptyList)

        presenter.attachView(this, context!!)
        presenter.proofOfMvp("proof!")
        // presenter.initComicList()
        //  presenter.fetchComicList(true)


        rvComics = view.findViewById(R.id.rvComics)

        val llm = LinearLayoutManager(context)
        rvComics.layoutManager = llm
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
                            //        if (recyclerState != null) {
                            //            rvComics.layoutManager?.onRestoreInstanceState(recyclerState)
                            //            recyclerState = null
                            //        }
                        },
                        { e ->
                            Log.e("NGVL", "Error", e)
                        }
                )
    }
}
