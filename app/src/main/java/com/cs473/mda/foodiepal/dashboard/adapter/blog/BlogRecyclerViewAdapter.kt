package com.cs473.mda.foodiepal.dashboard.adapter.blog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cs473.mda.foodiepal.databinding.BlogItemViewBinding

class BlogRecyclerViewAdapter(private val blogList: ArrayList<Blog>): RecyclerView.Adapter<BlogRecyclerViewAdapter.BlogViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val itemBinding = BlogItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BlogViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val blog: Blog = blogList[position]
        holder.bind(blog)
    }

    override fun getItemCount(): Int = blogList.size

    public fun add(blog: Blog) {
        blogList.add(blog)
    }

    class BlogViewHolder(private val itemBinding: BlogItemViewBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(blog: Blog) {
//            itemBinding.recipeTitle.text = recipe.title
//            itemBinding.recipeIngredients.text = recipe.ingredients
//            itemBinding.recipeInstructions.text = recipe.instruction
        }
    }
}