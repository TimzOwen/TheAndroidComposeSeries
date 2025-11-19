package com.example.happybirthdaycard.data

import com.example.happybirthdaycard.network.MarsApiService
import com.example.happybirthdaycard.network.MarsPhoto

interface MarsPhotosRepository {
    suspend fun getMarsPhots(): List<MarsPhoto>
}

class NetworkMarsPhotosRepository(
    private val marsApiService: MarsApiService
) : MarsPhotosRepository {

    override suspend fun getMarsPhots(): List<MarsPhoto> {
        return marsApiService.getPhotos()
    }
}