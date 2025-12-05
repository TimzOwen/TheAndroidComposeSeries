package com.example.happybirthdaycard.ui.books

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.happybirthdaycard.domain.Book
import com.example.happybirthdaycard.repository.BooksRepository
import com.example.happybirthdaycard.ui.BookUiState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BooksViewModel(
    private val repository: BooksRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<BookUiState>(BookUiState.Success(emptyList()))
    val uiState: StateFlow<BookUiState> = _uiState.asStateFlow()

    private var searchJob: Job? = null

    fun search(query: String) {
        if (query.isBlank()) {
            _uiState.value = BookUiState.Success(emptyList())
            return
        }
        _uiState.value = BookUiState.Loading
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            // small debounce to avoid spamming network on every keystroke
            delay(250)
            repository.searchBooks(query)
                .onSuccess { books ->
                    _uiState.value = BookUiState.Success(books)
                }
                .onFailure {
                    _uiState.value = BookUiState.Error
                }
        }
    }

    fun loadById(id: String, onLoaded: (Book?) -> Unit) {
        viewModelScope.launch {
            repository.getBookById(id)
                .onSuccess { onLoaded(it) }
                .onFailure { onLoaded(null) }
        }
    }
}

