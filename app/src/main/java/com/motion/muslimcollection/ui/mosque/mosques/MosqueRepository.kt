package com.motion.muslimcollection.ui.mosque.mosques

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.motion.muslimcollection.data.remote.RemoteDataSource
import com.motion.muslimcollection.model.address_model.MosqueItem
import com.motion.muslimcollection.network.result.Resource
import kotlinx.coroutines.Dispatchers

class MosqueRepository(private val remoteDataSource: RemoteDataSource) {

    fun getAllMosque(): LiveData<Resource<List<MosqueItem>>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.getAllMosque())
    }
    fun getMosqueItemByID(id:Int): LiveData<Resource<MosqueItem>> = liveData (Dispatchers.IO) {
        emit(Resource.loading(null))
        val result = remoteDataSource.getMosqueItemById(id)
        emit(result)
    }
    fun postMosqueItem(mosqueItem: MosqueItem): LiveData<Resource<MosqueItem>> = liveData(
        Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.postMosque(mosqueItem))
    }
    fun deleteMosqueItemById(id: Int): LiveData<Resource<MosqueItem>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.deleteMosqueItemById(id))
    }
}