package com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.widget.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.igttestproject.stanislavkinzl.tabtest.R
import com.igttestproject.stanislavkinzl.tabtest.app.ImageLoader
import com.igttestproject.stanislavkinzl.tabtest.app.model.Comic

class ComicsListAdapter(
        private val context: Context,
        private val imageLoader: ImageLoader
) : RecyclerView.Adapter<ComicsListAdapterViewHolder>() {

    private val comicsList: ArrayList<Comic> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsListAdapterViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.comic_card, parent, false)
        view.isFocusable = true
        return ComicsListAdapterViewHolder(view, imageLoader)
    }

    override fun onBindViewHolder(holder: ComicsListAdapterViewHolder, position: Int) {
        val comic = comicsList[position]
        holder.showComic(comic)
    }

    override fun getItemCount(): Int {
        return comicsList.size
    }

    internal fun addResults(results: List<Comic>) {
        comicsList.addAll(results)
        notifyDataSetChanged()
    }
}