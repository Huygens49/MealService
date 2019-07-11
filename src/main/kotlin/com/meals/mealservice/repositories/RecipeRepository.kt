package com.meals.mealservice.repositories

import com.meals.mealservice.domain.Recipe
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RecipeRepository : CrudRepository<Recipe, Int> {
    fun findRecipeById(id: Int): Recipe?
}