package com.motion.muslimcollection.ui.mosque.mosque_room

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.motion.muslimcollection.data.remote.RemoteDataSource
import com.motion.muslimcollection.model.address_model.RoomItem
import com.motion.muslimcollection.network.result.Resource
import kotlinx.coroutines.Dispatchers

class RoomRepository(private val remoteDataSource: RemoteDataSource) {

    fun getAllRoom(): LiveData<Resource<List<RoomItem>>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.getAllMosqueRoom())
    }
    fun getRoomItemByID(id:Int): LiveData<Resource<RoomItem>> = liveData (Dispatchers.IO) {
        emit(Resource.loading(null))
        val result = remoteDataSource.getRoomItemById(id)
        emit(result)
    }
    fun postRoomItem(item: RoomItem): LiveData<Resource<RoomItem>> = liveData(
        Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.postRoomItem(item))
    }
    fun deleteRoomItemById(id: Int): LiveData<Resource<RoomItem>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.deleteRoomItemById(id))
    }
}