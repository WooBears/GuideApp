package com.example.guideapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.guideapp.domain.GuideRepository
import com.example.guideapp.domain.usecases.GuideUseCase
import javax.inject.Inject

class GuidViewModel @Inject constructor(
    private val getGuideUseCase: GuideUseCase
) : ViewModel(){

    fun getGuide() = getGuideUseCase.execute()
}