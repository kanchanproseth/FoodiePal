package com.cs473.mda.foodiepal.dashboard.adapter.recipe

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cs473.mda.foodiepal.databinding.RecipeItemViewBinding

class RecipeRecyclerViewAdapter(private val recipeList: ArrayList<Recipe>): RecyclerView.Adapter<RecipeRecyclerViewAdapter.RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val itemBinding = RecipeItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe: Recipe = recipeList[position]
        holder.bind(recipe)
    }

    override fun getItemCount(): Int = recipeList.size

    public fun add(recipe: Recipe) {
        recipeList.add(recipe)
    }

    class RecipeViewHolder(private val itemBinding: RecipeItemViewBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(recipe: Recipe) {
            itemBinding.recipeTitle.text = recipe.title
            itemBinding.recipeIngredients.text = recipe.ingredients
            itemBinding.recipeInstructions.text = recipe.instruction
        }
    }
}