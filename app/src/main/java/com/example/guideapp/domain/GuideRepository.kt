package com.example.guideapp.domain

import androidx.lifecycle.LiveData
import com.example.guideapp.data.remote.dto.GuideEntity
import com.example.guideapp.data.remote.dto.GuideResponse

interface GuideRepository {

    fun getGuides() : LiveData<GuideEntity>
}