package com.meals.mealservice.repositories

import com.meals.mealservice.domain.Meal
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MealRepository : CrudRepository<Meal, Int> {
    fun findMealById(id: Int): Meal?
}