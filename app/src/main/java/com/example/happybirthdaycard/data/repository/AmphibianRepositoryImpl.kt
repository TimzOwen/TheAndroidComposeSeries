package com.example.happybirthdaycard.data.repository

import com.example.happybirthdaycard.data.mapper.toDomain
import com.example.happybirthdaycard.data.remote.service.AmphibianApiService
import com.example.happybirthdaycard.domain.model.Amphibian
import com.example.happybirthdaycard.domain.repository.AmphibianRepository
import javax.inject.Inject

class AmphibianRepositoryImpl @Inject constructor(
    private val amphibianApiService: AmphibianApiService
) : AmphibianRepository {
    override suspend fun fetchAmphibians(): List<Amphibian> {
        return amphibianApiService.getAmphibians().map { it.toDomain() }
    }
}