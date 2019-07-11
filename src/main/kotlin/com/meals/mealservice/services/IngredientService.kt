package com.meals.mealservice.services

import com.meals.mealservice.domain.Ingredient

interface IngredientService {

    fun getAllIngredients(): List<Ingredient>
    fun getIngredientById(id: Int): Ingredient
    fun addIngredient(ingredient: Ingredient): Ingredient
    fun updateIngredient(id: Int, ingredient: Ingredient)
    fun deleteIngredient(id: Int)

}