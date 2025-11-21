package com.example.happybirthdaycard.ui.screens

import com.example.happybirthdaycard.ui.model.Amphibian

data class AmphibiansUiState(
    val isLoading: Boolean = false,
    val errorState: String = "",
    val amphibians: List<Amphibian> = emptyList(),
    val error: String = ""
)
