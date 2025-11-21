package com.example.happybirthdaycard.di

import com.example.happybirthdaycard.data.remote.RetrofitConfig
import com.example.happybirthdaycard.data.remote.service.AmphibianApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = RetrofitConfig.create(BASE_URL)

    @Provides
    @Singleton
    fun provideAmphibianApiService(retrofit: Retrofit): AmphibianApiService =
        retrofit.create(AmphibianApiService::class.java)
}