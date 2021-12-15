package com.example.recipeapp.Adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.Activities.MainActivity2
import com.example.recipeapp.Model.RecipeItem
import com.example.recipeapp.databinding.RecipeItemRowBinding

class RecyclerViewAdapter(val context: Context, private val recipeList: List<RecipeItem>):
    RecyclerView.Adapter<RecyclerViewAdapter.HolderView>() {
    class HolderView(val binding: RecipeItemRowBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderView {
        return HolderView(
            RecipeItemRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HolderView, position: Int) {
        val recipe = recipeList[position]
        holder.binding.apply {
            tvTitle.text = recipe.title
            tvAuthor.text = recipe.author
            ///recipe.ingredients
            cardView.setOnClickListener {
                Toast.makeText(context, "${recipe.author}", Toast.LENGTH_LONG).show()
                Log.d("TAG", "onBindViewHolder: ${recipe.author} ")

                val intent:Intent
                intent = Intent(context, MainActivity2::class.java)
                intent.putExtra("titleData",recipe.title)
                intent.putExtra("authorData", recipe.author)
                intent.putExtra("ingredients", recipe.ingredients)
                intent.putExtra("instructions", recipe.instructions)
                context.startActivity(intent)

            }
        }
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }
}

