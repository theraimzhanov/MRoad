package com.motion.muslimcollection.ui.eat.cafe

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.motion.muslimcollection.core.base.BaseViewModel
import com.motion.muslimcollection.ext.parseInputField
import com.motion.muslimcollection.ext.parseNumber
import com.motion.muslimcollection.model.cafe_model.CafeItem
import com.motion.muslimcollection.model.cafe_model.CafeItemV
import com.motion.muslimcollection.network.result.Resource
import java.security.cert.Certificate

class CafeViewModel(private val repository: CafeRepository) : BaseViewModel() {

    var laoding = MutableLiveData<Boolean>()


    private var _list = MutableLiveData<Resource<List<CafeItem>>>()
    private var _item = MutableLiveData<Resource<CafeItem>>()

    // get Cafe List
    fun getCafeList() {
        _list = repository.getAllCafes() as MutableLiveData<Resource<List<CafeItem>>> }
    val list: LiveData<Resource<List<CafeItem>>>
        get() = _list

    // get CafeItem by id
    fun getCafeItem(id: Int) {
        _item = repository.getCafeItemByID(id) as MutableLiveData<Resource<CafeItem>> }
    val item: LiveData<Resource<CafeItem>>
        get() = _item

    // post CafeItem
    fun postCafeItem(name: String,location: String,phone: String,certificate:Boolean,mosqueRoom:Boolean) {

        val nameC = parseInputField(name)
        val locationC = parseInputField(location)
        val phoneC = parseNumber(phone)
        val boolean = validateInputName(nameC,phoneC,locationC)
        if (boolean){
            val item = CafeItemV(nameC,locationC,phoneC.toString(),certificate,mosqueRoom)
            repository.postCafeItem(item)
            finishWork()
        }
    }

    //delete CafeItem
    fun deleteCafeItem(id: Int){
        repository.deleteCafeItemById(id)
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


    private fun validateInputName(name:String,phone:Long,
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