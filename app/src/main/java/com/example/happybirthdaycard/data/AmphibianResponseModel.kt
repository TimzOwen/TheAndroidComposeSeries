package com.example.happybirthdaycard.data

import com.example.happybirthdaycard.ui.model.Amphibian
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@OptIn(InternalSerializationApi::class)
@Serializable
data class AmphibianResponseModel(
    @SerialName("name")
    val name: String,

    @SerialName("type")
    val type: String,

    @SerialName("description")
    val description: String,

    @SerialName("img_src")
    val imageSource: String
)

fun AmphibianResponseModel.asDomainObject(): Amphibian {
    return Amphibian(
        name = name,
        type = type,
        description = description,
        imageUrl = imageSource
    )
}
