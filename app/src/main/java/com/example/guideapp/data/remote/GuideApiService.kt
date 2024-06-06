package com.example.guideapp.data.remote

import com.example.guideapp.data.remote.dto.GuideEntity
import com.example.guideapp.data.remote.dto.GuideResponse
import retrofit2.Response
import retrofit2.http.GET

interface GuideApiService {
    @GET("upcomingGuide")
    suspend fun getGuides() : Response<GuideEntity>
}