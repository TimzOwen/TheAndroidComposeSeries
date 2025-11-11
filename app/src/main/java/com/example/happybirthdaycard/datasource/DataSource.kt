package com.example.happybirthdaycard.datasource

import com.example.happybirthdaycard.model.MenuItem

object MealItemData{

    val mainMeals = listOf(
        MenuItem("burger","Burger",6.50),
        MenuItem("pizza", "Pizza", 8.00),
        MenuItem("pasta", "Pasta", 7.25)
    )
    val desserts = listOf(
        MenuItem("ice_cream", "Ice Cream", 3.50),
        MenuItem("cake", "Cake", 4.00),
        MenuItem("fruit", "Fruit Salad", 3.00)
    )
    val drinks = listOf(
        MenuItem("water", "Water", 1.00),
        MenuItem("cola", "Cola", 2.00),
        MenuItem("juice", "Juice", 2.50)
    )

}