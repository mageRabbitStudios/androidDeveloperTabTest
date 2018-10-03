package com.igttestproject.stanislavkinzl.tabtest.mvp.repository.model

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.igttestproject.stanislavkinzl.tabtest.R
import kotlinx.android.synthetic.main.comic_item.view.*

class ComicsAdapter : BaseAdapter {

    var comicsList = ArrayList<Comic>()
    var context: Context? = null

    constructor(context: Context, comicsList: ArrayList<Comic>) : super() {
        this.context = context
        this.comicsList = comicsList
    }

    fun setComicList(comicsList: ArrayList<Comic>) {
        this.comicsList = comicsList
        notifyDataSetChanged()
    }

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val comic = this.comicsList[position]

        val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val comicView = inflator.inflate(R.layout.comic_item, null)
        comicView.item_thumbnail.setImageResource(comic.thumbnail!!)
        comicView.item_tv.text = comic.name!!

        return comicView
    }

    override fun getItem(position: Int): Any {
        return comicsList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return comicsList.size
    }
}