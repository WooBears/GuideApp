package com.example.guideapp.data.remote.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "guide")
data class GuideEntity (
    val name: String,
    val city: String,
    val state: String,
    val endDate: String,
    val icon: String,
    val url: String
){
}