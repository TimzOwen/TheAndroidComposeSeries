package com.example.happybirthdaycard.data.mapper

import com.example.happybirthdaycard.data.remote.AmphibianDto
import com.example.happybirthdaycard.domain.model.Amphibian

fun AmphibianDto.toDomain() = Amphibian (
    name = name,
    type = type,
    description = description,
    imageUrl = imageSource
)