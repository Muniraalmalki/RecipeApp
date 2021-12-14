package com.example.recipeapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.API.APIClient
import com.example.recipeapp.API.APIInterface
import com.example.recipeapp.R
import com.example.recipeapp.Recipe
import com.example.recipeapp.RecipeItem
import com.example.recipeapp.RecyclerViewAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddRecipeActivity : AppCompatActivity() {

    private lateinit var etTitle: EditText
    private lateinit var etAuthor: EditText
    private lateinit var etIngredients: EditText
    private lateinit var etInstructions: EditText
    private lateinit var submitButton: Button
    private lateinit var cancelButton: Button
    private lateinit var recipeList: ArrayList<RecipeItem>
    val apiClient = APIClient().getClient()?.create(APIInterface::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        recipeList = arrayListOf()

        etTitle = findViewById(R.id.etTitle)
        etAuthor = findViewById(R.id.etAuthor)
        etIngredients = findViewById(R.id.etIngredients)
        etInstructions = findViewById(R.id.etInstructions)

        submitButton = findViewById(R.id.SubmitButton)
        submitButton.setOnClickListener {
            val  title = etTitle.text.toString()
            val author = etAuthor.text.toString()
            val ingredients = etIngredients.text.toString()
            val instructions = etInstructions.text.toString()
            addRecipe(title,author,ingredients,instructions)

        }

        cancelButton = findViewById(R.id.cancelButton)
        cancelButton.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

    }

    // add data from user to API
    private fun addRecipe( title: String, author: String, ingredients: String, instructions: String){
        apiClient?.addRecipe(RecipeItem(title,author,ingredients,instructions))?.enqueue(object : Callback<RecipeItem> {
            override fun onResponse(call: Call<RecipeItem>, response: Response<RecipeItem>) {
                Toast.makeText(this@AddRecipeActivity,"user added successfully", Toast.LENGTH_LONG).show()

            }
            override fun onFailure(call: Call<RecipeItem>, t: Throwable) {
                Toast.makeText(this@AddRecipeActivity,"Something went wrong ", Toast.LENGTH_LONG).show()
            }
        })
    }


}