package com.meals.mealservice.domain

import org.joda.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "meals")
data class Meal(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "meal_id")
        val id: Int,

        @Column(name = "meal_date", nullable = false)
        var date: LocalDateTime,

        @Column(name = "meal_reaction", nullable = false)
        var reaction: Boolean = false,

        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
        @JoinColumn(name = "recipe_id")
        var recipe: Recipe
)