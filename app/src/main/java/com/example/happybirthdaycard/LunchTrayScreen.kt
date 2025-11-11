package com.example.happybirthdaycard


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.happybirthdaycard.datasource.DataSource
import com.example.happybirthdaycard.model.MenuItem
import com.example.happybirthdaycard.screens.AccompanimentMenuScreen
import com.example.happybirthdaycard.screens.CheckoutScreen
import com.example.happybirthdaycard.screens.EntreeMenuScreen
import com.example.happybirthdaycard.screens.OrderViewModel
import com.example.happybirthdaycard.screens.SideDishMenuScreen
import com.example.happybirthdaycard.screens.StartOrderScreen

enum class LunchTrayScreen {
    START,
    ENTREE_MENU,
    SIDE_DISH_MENU,
    ACCOMPANIMENT_MENU,
    CHECKOUT
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LunchTrayTopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    canNavigateBack: Boolean = false,
    navigateUp: () -> Unit
) {
    TopAppBar(
        title = { Text(text = title) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back_button)
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LunchTrayApp() {
    val navController = rememberNavController()
    val viewModel: OrderViewModel = viewModel()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = LunchTrayScreen.valueOf(
        backStackEntry?.destination?.route ?: LunchTrayScreen.START.name
    )

    Scaffold(
        topBar = {
            LunchTrayTopAppBar(
                title =currentScreen.name,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = {navController.navigateUp()}
            )
        }
    ) { innerPadding ->

        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = LunchTrayScreen.START.name,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(LunchTrayScreen.START.name) {
                StartOrderScreen(
                    onStartOrderButtonClicked = {
                        navController.navigate(LunchTrayScreen.ENTREE_MENU.name)
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }

            composable(route = LunchTrayScreen.ENTREE_MENU.name) {
                EntreeMenuScreen(
                    options = DataSource.entreeMenuItems,
                    onSelectionChanged = {
                        viewModel.updateEntree(it)
                    },
                    onCancelButtonClicked = {
                        viewModel.resetOrder()
                        navController.popBackStack(LunchTrayScreen.START.name, false)
                    },
                    onNextButtonClicked = {
                        navController.navigate(LunchTrayScreen.SIDE_DISH_MENU.name)
                    }
                )
            }

            composable(LunchTrayScreen.SIDE_DISH_MENU.name) {
                SideDishMenuScreen(
                    options = DataSource.sideDishMenuItems,
                    onCancelButtonClicked = {
                        viewModel.resetOrder()
                        navController.popBackStack(LunchTrayScreen.START.name, false)
                    },
                    onSelectionChanged = {
                        viewModel.updateSideDish(it)
                    },
                    onNextButtonClicked = {
                        navController.navigate(LunchTrayScreen.ACCOMPANIMENT_MENU.name)
                    }
                )
            }

            composable(route = LunchTrayScreen.ACCOMPANIMENT_MENU.name) {
                AccompanimentMenuScreen(
                    options = DataSource.accompanimentMenuItems,
                    onCancelButtonClicked = {
                        viewModel.resetOrder()
                        navController.popBackStack(LunchTrayScreen.START.name, false)
                    },
                    onSelectionChanged = {
                        viewModel.updateAccompaniment(it)
                    },
                    onNextButtonClicked = {
                        navController.navigate(LunchTrayScreen.CHECKOUT.name)
                    }
                )
            }

            composable(route = LunchTrayScreen.CHECKOUT.name) {
                CheckoutScreen(
                    orderUiState = uiState,
                    onNextButtonClicked = {
                        viewModel.resetOrder()
                        navController.popBackStack(LunchTrayScreen.START.name, false)
                    },
                    onCancelButtonClicked = {
                        viewModel.resetOrder()
                        navController.popBackStack(LunchTrayScreen.START.name, false)
                    }
                )
            }
        }
    }
}

























