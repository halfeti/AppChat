package com.quang.appchat.controller.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.quang.appchat.R
import kotlinx.android.synthetic.main.item_list_group_chat.view.*


class AdapterListGroup(val items: ArrayList<String>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

// Gets the number of animals in the list

    override fun getItemCount(): Int {
        return items.size
    }

// Inflates the item views

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_group_chat, p0, false))
    }

// Binds each animal in the ArrayList to a view

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.tvNamegroup?.text = items.get(position)
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

// Holds the TextView that will add each animal to

    val tvNamegroup = view.tv_name_group
}