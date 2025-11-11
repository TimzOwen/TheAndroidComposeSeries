package com.example.happybirthdaycard.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.happybirthdaycard.ui.screens.DessertScreen
import com.example.happybirthdaycard.ui.screens.DrinkScreen
import com.example.happybirthdaycard.ui.screens.MainMealScreen
import com.example.happybirthdaycard.ui.screens.MealsViewModel
import com.example.happybirthdaycard.ui.screens.SummaryScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsApp() {
    val navController = rememberNavController()
    val viewModel: MealsViewModel = viewModel()
    val uiState by viewModel.mealUiState.collectAsState()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    val appBarTitle = when (currentRoute) {
        Screens.MAIN_MEAL.name -> "Main Meal"
        Screens.DESSERT_MEAL.name -> "Dessert"
        Screens.DRINK_MEAL.name -> "Drink"
        Screens.SUMMARY_MEALS.name -> "Summary"
        else -> "Meals App"
    }

    val canNavigateBack = navController.previousBackStackEntry != null

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = appBarTitle,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                navigationIcon = {
                    if (canNavigateBack) {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                }
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Screens.MAIN_MEAL.name,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(route = Screens.MAIN_MEAL.name) {
                MainMealScreen(
                    state = uiState,
                    onSelect = {
                        viewModel.selectMainMeal(it)
                    },
                    onNext = {
                        navController.navigate(Screens.DESSERT_MEAL.name)
                    }
                )
            }

            composable(route = Screens.DESSERT_MEAL.name) {
                DessertScreen(
                    state = uiState,
                    onSelect = {
                        viewModel.selectDessertMeal(it)
                    },
                    onNext = {
                        navController.navigate(Screens.DRINK_MEAL.name)
                    },
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }

            composable(route = Screens.DRINK_MEAL.name) {
                DrinkScreen(
                    state = uiState,
                    onSelect = {
                        viewModel.selectDrinkMeal(it)
                    },
                    onNext = {
                        navController.navigate(Screens.SUMMARY_MEALS.name)
                    },
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }

            composable(route = Screens.SUMMARY_MEALS.name) {
                SummaryScreen(
                    state = uiState,
                    totalCost = viewModel.calculateTotalBill(),
                    onConfirm = {
                        viewModel.resetOrder()
                        navController.popBackStack(Screens.MAIN_MEAL.name, inclusive = false)
                    },
                    onBack = {
                        navController.popBackStack()
                    },
                )
            }
        }
    }
}

enum class Screens {
    MAIN_MEAL,
    DESSERT_MEAL,
    DRINK_MEAL,

    SUMMARY_MEALS
}

