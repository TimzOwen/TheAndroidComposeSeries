package com.example.happybirthdaycard.mapper

import com.example.happybirthdaycard.domain.Book
import com.example.happybirthdaycard.dto.VolumeItems


fun VolumeItems.toBook(): Book {
    return Book(
        id = id ?: "",
        title = volumeInfo?.title ?: "",
        authors = volumeInfo?.authors ?: emptyList(),
        thumbnailUrl = volumeInfo?.imageLinks?.smallThumbnail ?: "",
        publisher = volumeInfo?.publisher ?: "",
        publishedDate = volumeInfo?.publishedDate ?: "",
        description = volumeInfo?.description ?: "",
        pageCount = volumeInfo?.pageCount,
    )
}