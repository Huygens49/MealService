package com.meals.mealservice.repositories

import com.meals.mealservice.domain.Ingredient
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IngredientRepository : CrudRepository<Ingredient, Int> {
    fun findIngredientById(id: Int): Ingredient?
}