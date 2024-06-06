package com.example.guideapp.data.remote.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "guide")
data class GuideEntityDto (
    @PrimaryKey val id: Int,
    val name: String,
    val city: String,
    val state: String,
    val endDate: String,
    val icon: String,
    val url: String
){
    fun toGuide() : GuideEntity {
        return GuideEntity(
            name = name,
            city =  city,
            state =  state,
            endDate = endDate,
            icon = icon,
            url = url
        )
    }
}