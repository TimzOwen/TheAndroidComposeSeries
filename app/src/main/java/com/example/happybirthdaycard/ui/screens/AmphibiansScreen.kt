package com.example.happybirthdaycard.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.happybirthdaycard.ui.components.AmphibianCardComponent
import com.example.happybirthdaycard.ui.viewmodel.AmphibianViewModel

@Composable
fun HomeScreen(
    viewModel: AmphibianViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    when {
        uiState.isLoading -> CircularProgressIndicator()
        uiState.error != null -> Text("Error ${uiState.error}")
        else -> {
            LazyColumn(contentPadding = PaddingValues(16.dp)) {
                items(uiState.amphibians) {
                    AmphibianCardComponent(it)
                }
            }
        }
    }
}

