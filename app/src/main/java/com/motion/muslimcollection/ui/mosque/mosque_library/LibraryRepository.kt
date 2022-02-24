package com.motion.muslimcollection.ui.mosque.mosque_library

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.motion.muslimcollection.data.remote.RemoteDataSource
import com.motion.muslimcollection.model.address_model.MosqueLibraryItem
import com.motion.muslimcollection.network.result.Resource
import kotlinx.coroutines.Dispatchers

class LibraryRepository(private val remoteDataSource: RemoteDataSource) {

    fun getAllLibrary(): LiveData<Resource<List<MosqueLibraryItem>>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.getAllMosqueLibrary())
    }
    fun getLibraryItemByID(id:Int)
    : LiveData<Resource<MosqueLibraryItem>> = liveData (Dispatchers.IO) {
        emit(Resource.loading(null))
        val result = remoteDataSource.getMosqueLibraryItemById(id)
        emit(result)
    }
    fun postLibraryItem(libraryItem: MosqueLibraryItem)
    : LiveData<Resource<MosqueLibraryItem>> = liveData(
        Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.postMosqueLibrary(libraryItem))
    }
    fun deleteLibraryItemById(id: Int): LiveData<Resource<MosqueLibraryItem>>
    = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.deleteMosqueLibraryItemById(id))
    }
}