package com.example.happybirthdaycard.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.happybirthdaycard.data.NetworkAmphibiansRepo
import com.example.happybirthdaycard.data.asDomainObject
import com.example.happybirthdaycard.network.service
import com.example.happybirthdaycard.ui.model.Amphibian
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException


class AmphibiansViewModel(
    private val amphibiansRepo: NetworkAmphibiansRepo
) : ViewModel() {
    private val _uiState = MutableStateFlow(AmphibiansUiState())
    val uiState: StateFlow<AmphibiansUiState> = _uiState.asStateFlow()


    init {
        getAmphibians()
    }

    fun getAmphibians() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                val amphibians = service.getAmphibians().map { it.asDomainObject() }
                _uiState.update {
                    it.copy(amphibians = amphibians, isLoading = false)
                }
            } catch (e: IOException) {
                _uiState.update {
                    it.copy(isLoading = false, error = "Error ${e.message}")
                }
            }
        }
    }
}
