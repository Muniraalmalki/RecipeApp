package com.example.recipeapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.databinding.ActivityMain2Binding
import com.example.recipeapp.databinding.RecipeItem2Binding
import com.example.recipeapp.databinding.RecipeItemRowBinding

class RecyclerViewAdapter2(private val recipeList: List<RecipeItem>):
    RecyclerView.Adapter<RecyclerViewAdapter2.HolderView>() {
    class HolderView(val binding: RecipeItem2Binding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderView {
        return HolderView(
            RecipeItem2Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HolderView, position: Int) {
        val recipe = recipeList[position]
        holder.binding.apply {

            tvIngredients.text = recipe.ingredients
            tvInstructions.text = recipe.instructions
        }
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }
}
