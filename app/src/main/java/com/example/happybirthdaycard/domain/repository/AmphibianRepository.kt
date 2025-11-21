package com.example.happybirthdaycard.domain.repository

import com.example.happybirthdaycard.data.remote.service.AmphibianApiService
import com.example.happybirthdaycard.domain.model.Amphibian

interface AmphibianRepository {
    suspend fun fetchAmphibians(): List<Amphibian>
}