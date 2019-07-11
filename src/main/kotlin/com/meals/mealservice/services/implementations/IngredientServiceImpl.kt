package com.meals.mealservice.services.implementations

import com.meals.mealservice.domain.Ingredient
import com.meals.mealservice.repositories.IngredientRepository
import com.meals.mealservice.services.IngredientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityNotFoundException

@Service
class IngredientServiceImpl(@Autowired private val ingredientRepository: IngredientRepository) : IngredientService {

    override fun getAllIngredients(): List<Ingredient> {
        return ingredientRepository.findAll().toList()
    }

    override fun getIngredientById(id: Int): Ingredient {
        return ingredientRepository.findIngredientById(id) ?: throw EntityNotFoundException("Could not find ingredient $id.")
    }

    @Transactional
    override fun addIngredient(ingredient: Ingredient): Ingredient {
        return ingredientRepository.save(ingredient)
    }

    @Transactional
    override fun updateIngredient(id: Int, ingredient: Ingredient) {
        val updateIngredient = getIngredientById(id)
        updateIngredient.name = ingredient.name

        ingredientRepository.save(updateIngredient)
    }

    @Transactional
    override fun deleteIngredient(id: Int) {
        ingredientRepository.deleteById(id)
    }

}