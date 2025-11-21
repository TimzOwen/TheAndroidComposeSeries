package com.example.happybirthdaycard.data.remote

import com.example.happybirthdaycard.domain.model.Amphibian
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@OptIn(InternalSerializationApi::class)
@Serializable
data class AmphibianDto(
    @SerialName("name") val name: String,
    @SerialName("type") val type: String,
    @SerialName("description") val description: String,
    @SerialName("img_src") val imageSource: String
)
