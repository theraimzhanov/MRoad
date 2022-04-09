package com.motion.muslimcollection.ui.eat.restaurant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.motion.muslimcollection.core.base.BaseViewModel
import com.motion.muslimcollection.ext.parseInputField
import com.motion.muslimcollection.ext.parseNumber
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
    fun postRestaurant(name: String?,phone:String?,location:String?,certificate:Boolean,msRoom:Boolean){
        val valName = parseInputField(name)
        val valPhone = parseNumber(phone)
         val valLocation = parseInputField(location)
         val condition = validateInputField(valName,valPhone,valLocation)
        if (condition){
            repository.postRestaurantItem(RestaurantItem(valName,valPhone.toString(),valLocation,certificate,msRoom))
            finishWork()
        }
    }
    private val _errorInputName = MutableLiveData<Boolean>()
    val errorInputName: LiveData<Boolean>
        get() = _errorInputName

    private val _errorInputLocation = MutableLiveData<Boolean>()
    val errorInputLocation: LiveData<Boolean>
        get() = _errorInputLocation

    private val _errorInputPhoneNumber = MutableLiveData<Boolean>()
    val errorInputPhoneNumber: LiveData<Boolean>
        get() = _errorInputPhoneNumber

    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen

    private fun validateInputField(name:String,phone:Long,
                                  location:String
    ):Boolean{
        var result = true
        if (name.isBlank()) {
            _errorInputName.value = true
            result = false
        }
        if (location.isBlank()){
            _errorInputLocation.value = true
            result = false
        }
        if (phone <= 0) {
            _errorInputPhoneNumber.value = true
            result = false
        }
        return result
    }
    fun resetErrorInputName() {
        _errorInputName.value = false
    }
    fun resetErrorInputLocation() {
        _errorInputLocation.value = false
    }
    fun resetErrorInputPhone() {
        _errorInputPhoneNumber.value = false
    }
    private fun finishWork() {
        _shouldCloseScreen.value = Unit
    }
}