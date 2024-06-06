package com.example.guideapp.data.repository

import com.example.guideapp.data.baseRepo.BaseRepo
import com.example.guideapp.data.remote.GuideApiService
import com.example.guideapp.data.remote.dto.GuideEntity
import com.example.guideapp.domain.GuideRepository
import javax.inject.Inject

class GuideRepositoryImpl @Inject constructor(
    private val guideApiService: GuideApiService,
) : BaseRepo(), GuideRepository {

    override fun getGuides() = doRequest {
        guideApiService.getGuides()
    }
}