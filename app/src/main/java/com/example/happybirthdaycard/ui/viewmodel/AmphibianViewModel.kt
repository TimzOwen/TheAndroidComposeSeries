package com.example.happybirthdaycard.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.happybirthdaycard.domain.repository.AmphibianRepository
import com.example.happybirthdaycard.ui.state.AmphibianUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okio.IOException
import javax.inject.Inject

@HiltViewModel
class AmphibianViewModel @Inject constructor(
    private val amphibianRepository: AmphibianRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AmphibianUiState(isLoading = true))
    val uiState: StateFlow<AmphibianUiState> = _uiState.asStateFlow()

    init {
        loadAmphibians()
    }

    fun loadAmphibians() {
        _uiState.value = AmphibianUiState(isLoading = true)
        viewModelScope.launch {
            try {
                val amphibians = amphibianRepository.fetchAmphibians()
                _uiState.value = AmphibianUiState(amphibians = amphibians)
            } catch (e: Exception) {
                _uiState.value = AmphibianUiState(error = e.message ?: "Something went wrong")
            }
        }
    }

}