package com.example.happybirthdaycard.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.happybirthdaycard.model.MealsUiState
import com.example.happybirthdaycard.model.MenuItem

@Composable
fun MainMealScreen(
    state: MealsUiState,
    onSelect: (String) -> Unit,
    onNext: () -> Unit
) {
    SelectionScreen(
        "Choose your main",
        state.mainMeals,
        state.mainMealId,
        onSelect,
        false,
        null,
        onNext
    )
}

@Composable
fun DessertScreen(
    state: MealsUiState,
    onSelect: (String) -> Unit,
    onNext: () -> Unit,
    onBack: () -> Unit
) {
    SelectionScreen(
        "Choose a dessert",
        state.dessertMeals,
        state.dessertMealId,
        onSelect,
        true,
        onBack,
        onNext
    )
}

@Composable
fun DrinkScreen(
    state: MealsUiState,
    onSelect: (String) -> Unit,
    onNext: () -> Unit,
    onBack: () -> Unit
) {
    SelectionScreen(
        "Choose a drink",
        state.drinksMeals,
        state.drinksMealId,
        onSelect,
        true,
        onBack,
        onNext
    )
}

@Composable
fun SelectionScreen(
    title: String,
    items: List<MenuItem>,
    selectedId: String?,
    onSelect: (String) -> Unit,
    showBack: Boolean,
    onBack: (() -> Unit)?,
    onNext: () -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(title, style = MaterialTheme.typography.titleLarge)
        items.forEach { item ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .clickable { onSelect(item.id) }
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(selected = item.id == selectedId, onClick = { onSelect(item.id) })
                Spacer(Modifier.width(8.dp))
                Text("${item.name} - ${formatPrice(item.price)}")
            }
        }
        Spacer(Modifier.height(24.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            if (showBack && onBack != null) Button(onClick = onBack) { Text("Back") }
            Button(onClick = onNext, enabled = selectedId != null) { Text("Next") }
        }
    }
}

fun formatPrice(value: Double): String = "$" + String.format("%.2f", value)
