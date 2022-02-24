package com.motion.muslimcollection.ui.eat.magazine

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.motion.muslimcollection.data.remote.RemoteDataSource
import com.motion.muslimcollection.model.cafe_model.CafeItem
import com.motion.muslimcollection.model.cafe_model.MagazineItem
import com.motion.muslimcollection.network.result.Resource
import kotlinx.coroutines.Dispatchers

class MagazineRepository(private val remoteDataSource: RemoteDataSource) {
    fun getAllMagazine(): LiveData<Resource<List<MagazineItem>>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.getAllMagazines())
    }
    fun getMagazineItemByID(id:Int): LiveData<Resource<MagazineItem>> = liveData (Dispatchers.IO) {
        emit(Resource.loading(null))
        val result = remoteDataSource.getMagazineItemById(id)
        emit(result)
    }
    fun postMagazineItem(magazineItem: MagazineItem): LiveData<Resource<MagazineItem>> = liveData(
        Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.postMagazineItem(magazineItem))
    }
    fun deleteMagazineItemById(id: Int): LiveData<Resource<MagazineItem>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.deleteMagazineItemById(id))
    }
}