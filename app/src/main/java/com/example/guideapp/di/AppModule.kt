package com.example.guideapp.di

import com.example.guideapp.data.remote.GuideApiService
import com.example.guideapp.data.repository.GuideRepositoryImpl
import com.example.guideapp.domain.GuideRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://guidebook.com/service/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideGuideService(retrofit: Retrofit) : GuideApiService {
        return retrofit.create(GuideApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(guideApiService: GuideApiService) : GuideRepository {
        return GuideRepositoryImpl(guideApiService)
    }
}