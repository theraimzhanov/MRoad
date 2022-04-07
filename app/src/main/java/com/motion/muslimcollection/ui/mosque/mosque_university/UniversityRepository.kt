package com.motion.muslimcollection.ui.mosque.mosque_university

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.motion.muslimcollection.data.remote.RemoteDataSource
import com.motion.muslimcollection.model.address_model.RoomItem
import com.motion.muslimcollection.model.address_model.UniversityItem
import com.motion.muslimcollection.network.result.Resource
import kotlinx.coroutines.Dispatchers

class UniversityRepository(private val  remoteDataSource: RemoteDataSource) {

    fun getAllUniversity(): LiveData<Resource<List<UniversityItem>>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.getAllUniversity())
    }
    fun getUniversityItemByID(id:Int): LiveData<Resource<UniversityItem>> = liveData (Dispatchers.IO) {
        emit(Resource.loading(null))
        val result = remoteDataSource.getUniversity(id)
        emit(result)
    }
    fun postUniversityItem(item: UniversityItem): LiveData<Resource<UniversityItem>> = liveData(
        Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.postUniversity(item))
    }


}
