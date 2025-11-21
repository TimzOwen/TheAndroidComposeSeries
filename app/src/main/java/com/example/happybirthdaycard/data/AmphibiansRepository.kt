package com.example.happybirthdaycard.data

import com.example.happybirthdaycard.network.AmphibiansApiService

interface AmphibiansRepository {

    suspend fun getAmphibians(): List<AmphibianResponseModel>
}

class NetworkAmphibiansRepo(
    private val amphibiansApiService: AmphibiansApiService
) : AmphibiansRepository {
    override suspend fun getAmphibians(): List<AmphibianResponseModel> {
        return amphibiansApiService.getAmphibians()
    }
}