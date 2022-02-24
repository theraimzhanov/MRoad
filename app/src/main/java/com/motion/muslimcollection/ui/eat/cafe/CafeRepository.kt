package com.motion.muslimcollection.ui.eat.cafe

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.motion.muslimcollection.data.remote.RemoteDataSource
import com.motion.muslimcollection.model.cafe_model.CafeItem
import com.motion.muslimcollection.network.result.Resource
import kotlinx.coroutines.Dispatchers

class CafeRepository(private val remoteDataSource: RemoteDataSource) {

    fun getAllCafes(): LiveData<Resource<List<CafeItem>>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.getAllCafes())
    }
    fun getCafeItemByID(id:Int): LiveData<Resource<CafeItem>> = liveData (Dispatchers.IO) {
        emit(Resource.loading(null))
        val result = remoteDataSource.getCafeItemById(id)
        emit(result)
    }
    fun postCafeItem(cafeItem: CafeItem): LiveData<Resource<CafeItem>> = liveData(
        Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.postCafeItem(cafeItem))
    }
    fun deleteCafeItemById(id: Int):LiveData<Resource<CafeItem>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.deleteCafeItemById(id))
    }
}