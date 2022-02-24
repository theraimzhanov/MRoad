package com.motion.muslimcollection.ui.eat.fastfood

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.motion.muslimcollection.core.base.BaseViewModel
import com.motion.muslimcollection.model.cafe_model.FastFoodItem
import com.motion.muslimcollection.network.result.Resource
import com.motion.muslimcollection.ui.eat.cafe.CafeRepository

class FastFoodViewModel(private val repository: FastFoodRepository):BaseViewModel() {

    var laoding = MutableLiveData<Boolean>()

    private var _list = MutableLiveData<Resource<List<FastFoodItem>>>()
    private var _item = MutableLiveData<Resource<FastFoodItem>>()

    // get FastFood List
    fun getFastFoodList() {
        _list = repository.getAllFastFoods() as MutableLiveData<Resource<List<FastFoodItem>>>
    }
    val list: LiveData<Resource<List<FastFoodItem>>>
        get() = _list

    // get FastFood Item by id
    fun getFastFoodItem(id: Int) {
        _item = repository.getFastFoodItemByID(id) as MutableLiveData<Resource<FastFoodItem>>
    }
    val item: LiveData<Resource<FastFoodItem>>
        get() = _item

    // post FastFood Item
    fun postFastFoodItem(fastFoodItem: FastFoodItem) {
        repository.postFastFoodItem(fastFoodItem)
    }

    //delete FastFood Item by id
    fun deleteFastFoodItem(id: Int){
        repository.deleteFastFoodItemById(id)
    }
}