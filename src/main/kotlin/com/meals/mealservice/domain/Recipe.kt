package com.meals.mealservice.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "recipes")
data class Recipe(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "recipe_id")
        val id: Int,

        @Column(name = "recipe_name", nullable = false)
        var name: String,

        @ManyToMany(cascade = [CascadeType.PERSIST])
        @JoinTable(
                name = "recipes_ingredients",
                joinColumns = [JoinColumn(name = "recipe_id")],
                inverseJoinColumns = [JoinColumn(name = "ingredient_id")]
        )
        var ingredients: MutableList<Ingredient>
) {
    @JsonIgnore
    @OneToMany(mappedBy = "recipe", cascade = [CascadeType.REMOVE])
    val meals: List<Meal>? = null
}