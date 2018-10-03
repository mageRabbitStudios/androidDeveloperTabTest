package com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.model

import android.content.Context
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.igttestproject.stanislavkinzl.tabtest.R
import com.igttestproject.stanislavkinzl.tabtest.extensions.load
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.entity.Comic
import kotlinx.android.synthetic.main.comic_card.view.*

class ComicAdapter(
        private var context: Context,
        var comicsList: ArrayList<Comic>)
    : RecyclerView.Adapter<ComicAdapter.VH>() {


    override fun getItemCount(): Int {
        return comicsList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comic_card, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val comic = comicsList[position]
        holder.txtName.text = comic.title
        holder.imgThumbnail.load("${comic.thumbnail.path}/standard_medium.${comic.thumbnail.extension}")

        when(comic.pageCount) {
            0    -> holder.txtCount.text = context.getString(R.string.unknown_number_of_pages)
            else -> holder.txtCount.text = comic.pageCount.toString() + context.getString(R.string.pages)
        }
}

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgThumbnail = itemView.thumbnail
        val txtName = itemView.title
        val txtCount = itemView.count
       // val overflow = itemView.overflow
    }

    companion object {
        val comicDiff = object: DiffUtil.ItemCallback<Comic>() {
            override fun areItemsTheSame(old: Comic, new: Comic): Boolean {
                return old.id == new.id
            }

            override fun areContentsTheSame(old: Comic, new: Comic): Boolean {
                return old == new
            }

        }
    }
}