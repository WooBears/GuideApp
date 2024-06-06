package com.example.guideapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.guideapp.data.remote.dto.GuideEntity

@Dao
interface GuideDao {

    @Query("SELECT * FROM guide")
    fun getAllGuides(): LiveData<List<GuideEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGuides(guides: List<GuideEntity>)
}