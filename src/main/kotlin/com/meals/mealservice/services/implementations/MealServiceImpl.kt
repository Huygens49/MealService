package com.meals.mealservice.services.implementations

import com.meals.mealservice.domain.Meal
import com.meals.mealservice.repositories.MealRepository
import com.meals.mealservice.services.MealService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityNotFoundException

@Service
class MealServiceImpl(@Autowired private val mealRepository: MealRepository) : MealService {

    override fun getAllMeals(): List<Meal> {
        return mealRepository.findAll().toList()
    }

    override fun getMealById(id: Int): Meal {
        return mealRepository.findMealById(id) ?: throw EntityNotFoundException("Could not find meal $id.")
    }

    @Transactional
    override fun addMeal(meal: Meal): Meal {
        return mealRepository.save(meal)
    }

    @Transactional
    override fun updateMeal(id: Int, meal: Meal) {
        val updateMeal = getMealById(id)
        updateMeal.date = meal.date
        updateMeal.reaction = meal.reaction
        updateMeal.recipe = meal.recipe

        mealRepository.save(updateMeal)
    }

    @Transactional
    override fun deleteMeal(id: Int) {
        mealRepository.deleteById(id)
    }

}