package com.cs473.mda.foodiepal.dashboard.adapter.blog

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.cs473.mda.foodiepal.BlogDetailsActivity
import com.cs473.mda.foodiepal.databinding.BlogItemViewBinding

class BlogRecyclerViewAdapter(private val blogList: ArrayList<Blog>, val delegate: BlogItemOnClick): RecyclerView.Adapter<BlogRecyclerViewAdapter.BlogViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val itemBinding = BlogItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BlogViewHolder(itemBinding, delegate)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val blog: Blog = blogList[position]
        holder.bind(blog)
    }

    override fun getItemCount(): Int = blogList.size

    public fun add(blog: Blog) {
        blogList.add(blog)
    }

    class BlogViewHolder(private val itemBinding: BlogItemViewBinding, val delegate: BlogItemOnClick) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(blog: Blog) {
            itemBinding.blogTitle.text = blog.title
            itemBinding.blogImageView.load(blog.urlString)
            itemView.setOnClickListener {
                this.delegate.itemOnClick(blog)
            }
        }
    }
}