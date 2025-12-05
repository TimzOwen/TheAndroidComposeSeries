package com.example.happybirthdaycard.dto

import kotlinx.serialization.Serializable

@Serializable
data class VolumesResponse(
    val items: List<VolumeItems>? = null
)

@Serializable
data class VolumeItems(
    val id: String? = null,
    val volumeInfo: VolumeInfo? = null
)

@Serializable
data class VolumeInfo(
    val title: String? = null,
    val authors: List<String>? = null,
    val imageLinks: ImageLinks? = null,
    val publisher: String? = null,
    val publishedDate: String? = null,
    val description: String? = null,
    val pageCount: Int? = null,
)

@Serializable
data class ImageLinks(
    val smallThumbnail: String? = null,
    val thumbnail: String? = null
)