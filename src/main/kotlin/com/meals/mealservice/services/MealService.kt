package com.meals.mealservice.services

import com.meals.mealservice.domain.Meal

interface MealService {
    fun getAllMeals(): List<Meal>
    fun getMealById(id: Int): Meal
    fun addMeal(meal: Meal): Meal
    fun updateMeal(id: Int, meal: Meal)
    fun deleteMeal(id: Int)
}