package com.itsch.notitec2.inicio

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itsch.notitec2.R
import kotlinx.android.synthetic.main.item_post.view.*

/**
 * Created by Isma-Developer on 1/26/2018.
 */
class PostAdapter(val postList: List<Post>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {


    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindItems(postList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(v)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(postsItem: Post) = with(itemView) {
            itemView.name.text = postsItem.name
            itemView.date.text = postsItem.date
            itemView.description.text = postsItem.description
        }
    }

}