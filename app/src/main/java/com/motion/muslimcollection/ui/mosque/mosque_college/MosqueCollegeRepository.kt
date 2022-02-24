package com.motion.muslimcollection.ui.mosque.mosque_college

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.motion.muslimcollection.data.remote.RemoteDataSource
import com.motion.muslimcollection.model.address_model.MosqueCollegeItem
import com.motion.muslimcollection.network.result.Resource
import kotlinx.coroutines.Dispatchers

class MosqueCollegeRepository(private val remoteDataSource: RemoteDataSource) {

    fun getAllMosqueCollege(): LiveData<Resource<List<MosqueCollegeItem>>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.getAllMosqueCollege())
    }
    fun getMosqueCollegeItemByID(id:Int): LiveData<Resource<MosqueCollegeItem>> = liveData (Dispatchers.IO) {
        emit(Resource.loading(null))
        val result = remoteDataSource.getMosqueCollegeItemById(id)
        emit(result)
    }
    fun postMosqueCollegeItem(item: MosqueCollegeItem):
            LiveData<Resource<MosqueCollegeItem>> = liveData(
        Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.postMosqueCollegeItem(item))
    }
    fun deleteMosqueCollegeItemById(id: Int)
    : LiveData<Resource<MosqueCollegeItem>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.deleteMosqueCollegeItemById(id))
    }
}