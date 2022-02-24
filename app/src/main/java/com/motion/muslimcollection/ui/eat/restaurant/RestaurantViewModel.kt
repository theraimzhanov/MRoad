package com.motion.muslimcollection.ui.eat.restaurant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.motion.muslimcollection.core.base.BaseViewModel
import com.motion.muslimcollection.model.cafe_model.RestaurantItem
import com.motion.muslimcollection.network.result.Resource
import com.motion.muslimcollection.ui.eat.magazine.MagazineRepository

class RestaurantViewModel(private val repository: RestaurantRepository):BaseViewModel() {

    var laoding = MutableLiveData<Boolean>()

    private var _list = MutableLiveData<Resource<List<RestaurantItem>>>()
    private var _item = MutableLiveData<Resource<RestaurantItem>>()

    // get Restaurant List
    fun getRestaurantList() {
        _list = repository.getAllRestaurant() as MutableLiveData<Resource<List<RestaurantItem>>>
    }
    val list: LiveData<Resource<List<RestaurantItem>>>
        get() = _list

    // get RestaurantItem by id
    fun getRestaurantItem(id: Int) {
        _item = repository.getRestaurantItemByID(id) as MutableLiveData<Resource<RestaurantItem>>
    }
    val item: LiveData<Resource<RestaurantItem>>
        get() = _item

    // post Restaurant Item
    fun postRestaurantItem(restaurant: RestaurantItem) {
        repository.postRestaurantItem(restaurant)
    }

    //delete Restaurant Item by id
    fun deleteRestaurantItem(id: Int){
        repository.deleteRestaurantItemById(id)
    }
}