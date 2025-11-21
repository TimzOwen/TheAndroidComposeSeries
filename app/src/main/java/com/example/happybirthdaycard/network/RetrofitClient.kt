package com.example.happybirthdaycard.network

import com.example.happybirthdaycard.data.AmphibianResponseModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private val json = Json { ignoreUnknownKeys = true }

@OptIn(ExperimentalSerializationApi::class)
val retrofit = Retrofit.Builder()
    .baseUrl("https://developer.android.com")
    .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
    .build()

interface AmphibiansApiService {
    @GET("amphibians ")
    suspend fun getAmphibians(): List<AmphibianResponseModel>
}

val service: AmphibiansApiService = retrofit.create(AmphibiansApiService::class.java)
