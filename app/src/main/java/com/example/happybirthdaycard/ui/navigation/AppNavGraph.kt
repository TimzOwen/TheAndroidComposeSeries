package com.example.happybirthdaycard.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.happybirthdaycard.ui.books.BookDetailRoute
import com.example.happybirthdaycard.ui.books.BooksRoute

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoutes.Books) {

        composable(route = NavRoutes.Books) {
            BooksRoute(onBookClick = { id ->
                navController.navigate("${NavRoutes.BookDetail}/${id}")
            })
        }

        composable(
            route = "${NavRoutes.BookDetail}/{${NavRoutes.ArgBookId}}",
            arguments = listOf(navArgument(NavRoutes.ArgBookId) { type = NavType.StringType })
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getString(NavRoutes.ArgBookId) ?: ""
            BookDetailRoute(bookId = bookId)
        }
    }
}