package com.example.happybirthdaycard.ui.screens

import androidx.lifecycle.ViewModel
import com.example.happybirthdaycard.model.MealsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MealsViewModel : ViewModel() {
    private val _mealUiState = MutableStateFlow(MealsUiState())
    val mealUiState: StateFlow<MealsUiState> = _mealUiState.asStateFlow()

    fun selectMainMeal(mealId: String) {
        _mealUiState.value = _mealUiState.value.copy(
            mainMealId = mealId
        )
    }

    fun selectDessertMeal(mealId: String) {
        _mealUiState.value = _mealUiState.value.copy(
            dessertMealId = mealId
        )
    }

    fun selectDrinkMeal(mealId: String) {
        _mealUiState.value = _mealUiState.value.copy(
            drinksMealId = mealId
        )
    }

    fun resetOrder() {
        _mealUiState.value = MealsUiState()
    }

    fun calculateTotalBill(): Double {
        val state = _mealUiState.value
        return listOfNotNull(
            state.mainMeals.find { it.id == state.mainMealId }?.price,
            state.dessertMeals.find { it.id == state.dessertMealId }?.price,
            state.drinksMeals.find { it.id == state.drinksMealId }?.price
        ).sum()
    }

}