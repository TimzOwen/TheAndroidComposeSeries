package com.example.happybirthdaycard.model

import com.example.happybirthdaycard.datasource.MealItemData

data class MealsUiState(
    val mainMealId: String? = null,
    val dessertMealId: String? = null,
    val drinksMealId: String? = null,
    val mainMeals: List<MenuItem> = MealItemData.mainMeals,
    val dessertMeals: List<MenuItem> = MealItemData.desserts,
    val drinksMeals: List<MenuItem> = MealItemData.drinks,
)
