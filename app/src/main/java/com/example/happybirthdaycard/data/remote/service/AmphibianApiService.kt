package com.example.happybirthdaycard.data.remote.service

import com.example.happybirthdaycard.data.remote.AmphibianDto
import retrofit2.http.GET

interface AmphibianApiService{

    @GET("amphibians")
    suspend fun getAmphibians(): List<AmphibianDto>

}