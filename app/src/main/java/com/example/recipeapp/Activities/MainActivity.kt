package com.example.recipeapp.Activities



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var addRecipeButton: Button
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var recipeList: ArrayList<RecipeItem>
     val apiClient = APIClient().getClient()?.create(APIInterface::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recipeList = arrayListOf()
        recyclerView = findViewById(R.id.recyclerView)

        getAllRecipe()


        addRecipeButton = findViewById(R.id.addRecipeButton)
        addRecipeButton.setOnClickListener {
        startActivity(Intent(this,AddRecipeActivity::class.java))
    }
    }

    private fun getAllRecipe() {
        apiClient?.getAllRecipe()?.enqueue(object : Callback<Recipe> {
            override fun onResponse(call: Call<Recipe>, response: Response<Recipe>) {

                val recipeList = response.body()!!
                recyclerView.adapter = RecyclerViewAdapter(this@MainActivity, recipeList)
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerView.adapter?.notifyDataSetChanged()
            }
            override fun onFailure(call: Call<Recipe>, t: Throwable) {
                Toast.makeText(applicationContext,"Something get data ", Toast.LENGTH_LONG).show()
            }
        })
    }
}