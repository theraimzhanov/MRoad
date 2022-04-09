package com.motion.muslimcollection.ui.eat.magazine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.motion.muslimcollection.core.base.BaseViewModel
import com.motion.muslimcollection.ext.parseInputField
import com.motion.muslimcollection.ext.parseNumber
import com.motion.muslimcollection.model.cafe_model.MagazineItem
import com.motion.muslimcollection.model.vacancy_model.VacancyItem
import com.motion.muslimcollection.network.result.Resource
import com.motion.muslimcollection.ui.eat.fastfood.FastFoodRepository
import com.motion.muslimcollection.ui.vacancy.model.RezItem

class MagazineViewModel(private val repository: MagazineRepository):BaseViewModel() {

    var laoding = MutableLiveData<Boolean>()

    private var _list = MutableLiveData<Resource<List<MagazineItem>>>()
    private var _item = MutableLiveData<Resource<MagazineItem>>()

    // get Magazine List
    fun getMagazineList() {
        _list = repository.getAllMagazine() as MutableLiveData<Resource<List<MagazineItem>>>
    }
    val list: LiveData<Resource<List<MagazineItem>>>
        get() = _list

    // get MagazineItem by id
    fun getMagazineItem(id: Int) {
        _item = repository.getMagazineItemByID(id) as MutableLiveData<Resource<MagazineItem>>
    }
    val item: LiveData<Resource<MagazineItem>>
        get() = _item

    // post Magazine Item
    fun postMagazineItem(name:String?,phone: String?,address:String?,certificate:Boolean,msRoom:Boolean,img:String?,workTime:String) {
        val nameMG = parseInputField(name)
        val phoneMG = parseNumber(phone)
        val addressNG = parseInputField(address)
        val condition = validateInputName(nameMG,phoneMG,addressNG)
        if (condition){
            repository.postMagazineItem(MagazineItem(nameMG,phoneMG.toString()
                ,addressNG, certificate = certificate, mosqueRoom = msRoom, images = img, worktime = workTime))
            finishWork()
        }
    }

    private val _errorInputName = MutableLiveData<Boolean>()
    val errorInputName: LiveData<Boolean>
        get() = _errorInputName

    private val _errorInputPhoneNumber = MutableLiveData<Boolean>()
    val errorInputPhoneNumber: LiveData<Boolean>
        get() = _errorInputPhoneNumber

    private val _errorInputAddress = MutableLiveData<Boolean>()
    val errorInputAddress: LiveData<Boolean>
        get() = _errorInputAddress

    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen

    private fun validateInputName(name:String,phone:Long
                                  ,address:String
    ):Boolean{
        var result = true
        if (name.isBlank()) {
            _errorInputName.value = true
            result = false
        }
        if (phone <= 0) {
            _errorInputPhoneNumber.value = true
            result = false
        }
        if (address.isBlank()){
            _errorInputAddress.value = true
            result = false
        }
        return result
    }

    fun resetErrorInputName() {
        _errorInputName.value = false
    }

    fun resetErrorInputPhoneNumber() {
        _errorInputPhoneNumber.value = false
    }

    fun resetErrorInputAddress() {
        _errorInputAddress.value = false
    }
    private fun finishWork() {
        _shouldCloseScreen.value = Unit
    }

}