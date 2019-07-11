package com.meals.mealservice.web.controllers

import com.meals.mealservice.domain.Recipe
import com.meals.mealservice.services.RecipeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("v1/recipes")
@RestController
class RecipeController(@Autowired private val recipeService: RecipeService) {

    //TODO turn off open-in-view

    @GetMapping
    fun getAllRecipes() : List<Recipe> {
        return recipeService.getAllRecipes()
    }

    @GetMapping("{id}")
    fun getRecipeById(@PathVariable id: Int): Recipe {
        return recipeService.getRecipeById(id)
    }

}