package com.meals.mealservice.services.implementations

import com.meals.mealservice.domain.Recipe
import com.meals.mealservice.repositories.RecipeRepository
import com.meals.mealservice.services.RecipeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityNotFoundException

@Service
class RecipeServiceImpl(@Autowired private val recipeRepository: RecipeRepository) : RecipeService {

    override fun getAllRecipes(): List<Recipe> {
        return recipeRepository.findAll().toList()
    }

    override fun getRecipeById(id: Int): Recipe {
        return recipeRepository.findRecipeById(id) ?: throw EntityNotFoundException("Could not find recipe $id.")
    }

    @Transactional
    override fun addRecipe(recipe: Recipe): Recipe {
        return recipeRepository.save(recipe)
    }

    @Transactional
    override fun updateRecipe(id: Int, recipe: Recipe) {
        val updateRecipe = getRecipeById(id)
        updateRecipe.name = recipe.name
        updateRecipe.ingredients = recipe.ingredients

        recipeRepository.save(updateRecipe)
    }

    @Transactional
    override fun deleteRecipe(id: Int) {
        recipeRepository.deleteById(id)
    }

}