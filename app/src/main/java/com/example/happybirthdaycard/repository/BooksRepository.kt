package com.example.happybirthdaycard.repository

import com.example.happybirthdaycard.domain.Book
import com.example.happybirthdaycard.dto.VolumesResponse
import com.example.happybirthdaycard.mapper.toBook
import com.example.happybirthdaycard.network.GoogleBooksService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BooksRepository(
    private val service: GoogleBooksService
) {

    suspend fun searchBooks(query: String): Result<List<Book>> = withContext(Dispatchers.IO) {
        runCatching {
            service.searchVolume(query).items.orEmpty()
                .map { it.toBook() }
        }
    }

    suspend fun getBookById(bookId: String): Result<Book> = withContext(Dispatchers.IO) {
        runCatching {
            service.getVolumeById(bookId).toBook()
        }
    }
}