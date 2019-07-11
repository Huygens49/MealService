package com.meals.mealservice.services

import com.meals.mealservice.domain.Recipe

interface RecipeService {
    fun getAllRecipes(): List<Recipe>
    fun getRecipeById(id: Int): Recipe
    fun addRecipe(recipe: Recipe): Recipe
    fun updateRecipe(id: Int, recipe: Recipe)
    fun deleteRecipe(id: Int)
}