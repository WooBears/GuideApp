package com.example.guideapp.data.baseRepo

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.guideapp.data.remote.dto.GuideEntity
import com.example.guideapp.data.remote.dto.GuideResponse
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

abstract class BaseRepo(
    //private var guideDao: GuideDao
) {

    protected fun doRequest(
        request: suspend () -> Response<GuideEntity>
    ) : LiveData<GuideEntity> = liveData(Dispatchers.IO){
        try {
            val response = request()
            if (response.isSuccessful) {
                response.body()?.let {
                    //guideDao.insertGuides(it.data)
                    emit(it)
                }
            }
        }catch (e: Exception){

        }
    }
}