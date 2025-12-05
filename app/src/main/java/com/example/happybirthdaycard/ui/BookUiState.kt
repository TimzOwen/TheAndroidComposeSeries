package com.example.happybirthdaycard.ui

import com.example.happybirthdaycard.domain.Book

sealed interface BookUiState{
    data class Success(
        val books: List<Book>
    ) : BookUiState

    object Error : BookUiState

    object Loading : BookUiState
}
