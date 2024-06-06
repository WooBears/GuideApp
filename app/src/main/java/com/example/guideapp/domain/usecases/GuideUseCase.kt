package com.example.guideapp.domain.usecases

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.guideapp.data.remote.dto.GuideEntity
import com.example.guideapp.domain.GuideRepository
import javax.inject.Inject

class GuideUseCase @Inject constructor(
    private val guideRepository: GuideRepository
){
    fun execute() : LiveData<GuideEntity>{
        return guideRepository.getGuides().map {it }
    }
}