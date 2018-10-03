package com.igttestproject.stanislavkinzl.tabtest.mvp.repository.model

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.igttestproject.stanislavkinzl.tabtest.R
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.entity.Comic

class ComicsAdapter2 : PagedListAdapter<Comic, CharactersAdapter.VH>(characterDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val comic = getItem(position)
        holder.txtName.text = comic?.name
        holder.imgThumbnail.load("${comic?.thumbnail?.path}/standard_medium.${character?.thumbnail?.extension}")
    }

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgThumbnail = itemView.imgThumbnail
        val txtName = itemView.txtName
    }

    companion object {
        val characterDiff = object: DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(old: Character, new: Character): Boolean {
                return old.id == new.id
            }

            override fun areContentsTheSame(old: Character, new: Character): Boolean {
                return old == new
            }

        }
    }
}