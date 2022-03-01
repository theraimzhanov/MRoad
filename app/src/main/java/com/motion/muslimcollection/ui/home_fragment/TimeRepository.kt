package com.motion.muslimcollection.ui.home_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.motion.muslimcollection.data.remote.RemoteDataSource
import com.motion.muslimcollection.model.time_model.TimeItem
import com.motion.muslimcollection.network.result.Resource
import kotlinx.coroutines.Dispatchers

class TimeRepository(private val remoteDataSource: RemoteDataSource) {

    fun getTimeItemByDate(date:String): LiveData<Resource<TimeItem>> = liveData (Dispatchers.IO) {
        emit(Resource.loading(null))
        val result = remoteDataSource.getTimeItemByDate(date)
        emit(result)
    }
}