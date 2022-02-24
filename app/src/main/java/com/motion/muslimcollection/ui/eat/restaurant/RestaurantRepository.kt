package com.motion.muslimcollection.ui.eat.restaurant

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.motion.muslimcollection.data.remote.RemoteDataSource
import com.motion.muslimcollection.model.cafe_model.CafeItem
import com.motion.muslimcollection.model.cafe_model.RestaurantItem
import com.motion.muslimcollection.network.result.Resource
import kotlinx.coroutines.Dispatchers

class RestaurantRepository(private val remoteDataSource: RemoteDataSource) {
    fun getAllRestaurant(): LiveData<Resource<List<RestaurantItem>>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.getAllRestaurants())
    }
    fun getRestaurantItemByID(id:Int): LiveData<Resource<RestaurantItem>> = liveData (Dispatchers.IO) {
        emit(Resource.loading(null))
        val result = remoteDataSource.getRestaurantItemByID(id)
        emit(result)
    }
    fun postRestaurantItem(restaurantItem: RestaurantItem): LiveData<Resource<RestaurantItem>> = liveData(
        Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.postRestaurantItem(restaurantItem))
    }
    fun deleteRestaurantItemById(id: Int): LiveData<Resource<RestaurantItem>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(remoteDataSource.deleteRestaurantItemByID(id))
    }
}