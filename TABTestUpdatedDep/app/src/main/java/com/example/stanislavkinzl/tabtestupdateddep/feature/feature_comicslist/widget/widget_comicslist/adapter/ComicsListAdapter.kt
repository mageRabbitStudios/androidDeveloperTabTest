package com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.widget.widget_comicslist.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.stanislavkinzl.tabtestupdateddep.R
import com.example.stanislavkinzl.tabtestupdateddep.app.ImageLoader
import com.example.stanislavkinzl.tabtestupdateddep.app.model.Comic

class ComicsListAdapter(
    private val context: Context
    , private val imageLoader: ImageLoader
) : RecyclerView.Adapter<ComicsListAdapterVH>() {

    private val comicsList: ArrayList<Comic> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsListAdapterVH {
        val view = LayoutInflater.from(context).inflate(R.layout.comic_card, parent, false)
        view.isFocusable = true
        return ComicsListAdapterVH(view, imageLoader)
    }

    override fun onBindViewHolder(holder: ComicsListAdapterVH, position: Int) {
        val comic = comicsList[position]
        holder.showComic(comic)
    }

    override fun getItemCount(): Int {
        return comicsList.size
    }

    internal fun addResults(results: List<Comic>) {
        with(comicsList) {
            clear()
            addAll(results)
        }
        notifyDataSetChanged()
    }
}