package com.igttestproject.stanislavkinzl.tabtest.mvp.repository.model

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.igttestproject.stanislavkinzl.tabtest.R
import com.igttestproject.stanislavkinzl.tabtest.extensions.load
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.entity.Comic
import kotlinx.android.synthetic.main.comic_item.view.*

class ComicAdapter : PagedListAdapter<Comic, ComicAdapter.VH>(characterDiff) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comic_item, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val comic = getItem(position)
        holder.txtName.text = comic?.name
        holder.imgThumbnail.load("${comic?.thumbnail?.path}/standard_medium.${comic?.thumbnail?.extension}")
    }

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgThumbnail = itemView.item_thumbnail
        val txtName = itemView.item_tv
    }

    companion object {
        val characterDiff = object: DiffUtil.ItemCallback<Comic>() {
            override fun areItemsTheSame(old: Comic, new: Comic): Boolean {
                return old.id == new.id
            }

            override fun areContentsTheSame(old: Comic, new: Comic): Boolean {
                return old == new
            }

        }
    }
}