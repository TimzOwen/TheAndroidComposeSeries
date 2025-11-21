package com.example.happybirthdaycard.ui.state

import com.example.happybirthdaycard.domain.model.Amphibian

data class AmphibianUiState(
    val isLoading: Boolean = false,
    val amphibians: List<Amphibian> = emptyList(),
    val error: String? = null
)
