package com.example.recipeapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.recipeapp.R

class MainActivity2 : AppCompatActivity() {

    private lateinit var backButton: Button
    private lateinit var ingredients: TextView
    private lateinit var instructions: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar!!.setDisplayShowTitleEnabled(true)
        supportActionBar!!.title = "Full Recipe"

        ingredients = findViewById(R.id.tvIngredients)
        instructions = findViewById(R.id.tvInstructions)

        val ingredients1 =  intent.getStringExtra("ingredients")
        val instructions2  = intent.getStringExtra("instructions")


        ingredients.text = ingredients1
        instructions.text = instructions2

        backButton = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }

}