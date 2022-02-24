package com.motion.muslimcollection.ui.mosque.mosque_madrasah

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.motion.muslimcollection.data.remote.RemoteDataSource
import com.motion.muslimcollection.model.address_model.MadrasahItem
import com.motion.muslimcollection.network.result.Resource
import kotlinx.coroutines.Dispatchers

class MadrasahRepository(private val remoteDataSource: RemoteDataSource) {
    fun getAllMadrasah(): LiveData<Resource<List<MadrasahItem>>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.getAllMadrasah())
    }
    fun getMadrasahItemByID(id:Int): LiveData<Resource<MadrasahItem>> = liveData (Dispatchers.IO) {
        emit(Resource.loading(null))
        val result = remoteDataSource.getMadrasahItemById(id)
        emit(result)
    }
    fun postMadrasahItem(item: MadrasahItem): LiveData<Resource<MadrasahItem>> = liveData(
        Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.postMadrasahItem(item))
    }
    fun deleteMadrasahItemById(id: Int): LiveData<Resource<MadrasahItem>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.deleteMadrasahItemById(id))
    }
}