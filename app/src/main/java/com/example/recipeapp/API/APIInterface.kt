package com.example.recipeapp.API

import com.example.recipeapp.Recipe
import com.example.recipeapp.RecipeItem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIInterface {
    @GET("/recipes/")
    fun getAllRecipe():Call<Recipe>

    @POST("/recipes/")
    fun addRecipe(@Body data:RecipeItem):Call<RecipeItem>
}