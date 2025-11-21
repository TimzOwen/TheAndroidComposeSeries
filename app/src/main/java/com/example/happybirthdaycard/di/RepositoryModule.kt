package com.example.happybirthdaycard.di

import com.example.happybirthdaycard.data.remote.service.AmphibianApiService
import com.example.happybirthdaycard.data.repository.AmphibianRepositoryImpl
import com.example.happybirthdaycard.domain.repository.AmphibianRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAmphibianRepository(service: AmphibianApiService): AmphibianRepository =
        AmphibianRepositoryImpl(service)
}