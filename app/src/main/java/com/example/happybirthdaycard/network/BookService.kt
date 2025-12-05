package com.example.happybirthdaycard.network

import com.example.happybirthdaycard.dto.VolumeItems
import com.example.happybirthdaycard.dto.VolumesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class GoogleBooksService(
    private val client: HttpClient
) {

    suspend fun searchVolume(query: String): VolumesResponse =
        client.get("volumes") {
            parameter("q", query)
        }.body()

    suspend fun getVolumeById(volumeId: String): VolumeItems =
        client.get("volumes/$volumeId").body()

}