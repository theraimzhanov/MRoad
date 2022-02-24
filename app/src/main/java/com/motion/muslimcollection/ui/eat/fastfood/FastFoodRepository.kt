package com.motion.muslimcollection.ui.eat.fastfood

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.motion.muslimcollection.data.remote.RemoteDataSource
import com.motion.muslimcollection.model.cafe_model.CafeItem
import com.motion.muslimcollection.model.cafe_model.FastFoodItem
import com.motion.muslimcollection.network.result.Resource
import kotlinx.coroutines.Dispatchers

class FastFoodRepository(private val remoteDataSource: RemoteDataSource) {

    fun getAllFastFoods(): LiveData<Resource<List<FastFoodItem>>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.getAllFastFoods())
    }
    fun getFastFoodItemByID(id:Int): LiveData<Resource<FastFoodItem>> = liveData (Dispatchers.IO) {
        emit(Resource.loading(null))
        val result = remoteDataSource.getFastFoodItemByID(id)
        emit(result)
    }
    fun postFastFoodItem(fastFoodItem: FastFoodItem): LiveData<Resource<FastFoodItem>> = liveData(
        Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.postFastFoodItem(fastFoodItem))
    }
    fun deleteFastFoodItemById(id: Int): LiveData<Resource<FastFoodItem>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.deleteFastFoodItemByID(id))
    }
}