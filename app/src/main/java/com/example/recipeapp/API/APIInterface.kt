package com.example.recipeapp.API

import com.example.recipeapp.Model.Recipe
import com.example.recipeapp.Model.RecipeItem

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIInterface {
    @GET("/recipes/")
    fun getAllRecipe():Call<Recipe>

    @POST("/recipes/")
    fun addRecipe(@Body data: RecipeItem):Call<RecipeItem>
}