package com.meals.mealservice.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "ingredients")
data class Ingredient(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ingredient_id")
        val id: Int?,

        @Column(name = "ingredient_name", nullable = false)
        var name: String?
) {
    @JsonIgnore
    @ManyToMany(mappedBy = "ingredients", cascade = [CascadeType.REMOVE])
    val recipes: List<Recipe>? = null
}