package com.meals.mealservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MealServiceApplication

fun main(args: Array<String>) {
	runApplication<MealServiceApplication>(*args)
}
