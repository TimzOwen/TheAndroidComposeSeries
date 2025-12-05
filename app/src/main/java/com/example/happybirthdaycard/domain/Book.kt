package com.example.happybirthdaycard.domain

data class Book(
    val id: String,
    val title: String,
    val authors: List<String>,
    val thumbnailUrl: String?,
    val publisher: String,
    val publishedDate: String,
    val description: String,
    val pageCount: Int?,
)
