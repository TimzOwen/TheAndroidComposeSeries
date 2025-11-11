package com.example.happybirthdaycard.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.happybirthdaycard.model.MealsUiState

@Composable
fun SummaryScreen(
    state: MealsUiState,
    totalCost: Double,
    onConfirm: () -> Unit,
    onBack: () -> Unit
) {
    val main = state.mainMeals.find { it.id == state.mainMealId }
    val dessert = state.dessertMeals.find { it.id == state.dessertMealId }
    val drink = state.drinksMeals.find { it.id == state.drinksMealId }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Your order", style = MaterialTheme.typography.titleLarge)
        SummaryRow("Main", main?.name, main?.price)
        SummaryRow("Dessert", dessert?.name, dessert?.price)
        SummaryRow("Drink", drink?.name, drink?.price)

        Divider()

        Text("Total: ${formatPrice(totalCost)}", style = MaterialTheme.typography.titleMedium)
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(onClick = onBack) { Text("Back") }
            Button(onClick = onConfirm, enabled = main != null) { Text("Place order") }
        }
    }
}

@Composable
private fun SummaryRow(label: String, name: String?, price: Double?) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text("$label: ${name ?: "-"}")
        Text(price?.let { formatPrice(it) } ?: "-")
    }
}
