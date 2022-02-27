package com.motion.muslimcollection.ui.vacancy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.motion.muslimcollection.core.base.BaseViewModel
import com.motion.muslimcollection.model.vacancy_model.VacancyItem
import com.motion.muslimcollection.network.result.Resource
import com.motion.muslimcollection.ui.vacancy.model.RezItem

class VacancyViewModel(private val repository: VacancyRepository) : BaseViewModel() {

    var laoding = MutableLiveData<Boolean>()

    // get Vacancy by ID
    private var _item = MutableLiveData<Resource<VacancyItem>>()
    fun getVacancyItem(id: Int) {
        _item = repository.getVacancyItem(id) as MutableLiveData<Resource<VacancyItem>>
    }
    val item: LiveData<Resource<VacancyItem>>
        get() = _item

    // get Vacancy List
    private var _list = MutableLiveData<Resource<List<VacancyItem>>>()
    fun getVacancyList() {
        _list = repository.getVacancyList() as MutableLiveData<Resource<List<VacancyItem>>>
    }
    val list: LiveData<Resource<List<VacancyItem>>>
        get() = _list

    // add Vacancy Item
    private var _add = MutableLiveData<Resource<VacancyItem>>()
    fun parseRezItem(phone:String?, email:String?
                     , name:String?, birthDay:String?
                     , town:String?, proWork:String?, level:String?) {
         val nameV = parseInputField(name)
         val phoneV = parseNumber(phone)
         val emailV = parseInputField(email)
         val day = parseInputField(birthDay)
         val townV = parseInputField(town)
         val proV = parseInputField(proWork)
         val levelV = parseInputField(level)
        val fieldsValid = validateInputName(phoneV,emailV
            ,nameV,day,townV,proV,levelV)
        if (fieldsValid){
val item = RezItem(phoneV,emailV,nameV,day,townV,proV,levelV)
            // request send
            finishWork()
        }
    }
    val add: LiveData<Resource<VacancyItem>>
        get() = _add

    private val _errorInputName = MutableLiveData<Boolean>()
    val errorInputName: LiveData<Boolean>
        get() = _errorInputName

    private val _errorInputBirthDay = MutableLiveData<Boolean>()
    val errorInputBirthDay: LiveData<Boolean>
        get() = _errorInputBirthDay

    private val _errorInputTown = MutableLiveData<Boolean>()
    val errorInputTown: LiveData<Boolean>
        get() = _errorInputTown

    private val _errorInputPhoneNumber = MutableLiveData<Boolean>()
    val errorInputPhoneNumber: LiveData<Boolean>
        get() = _errorInputPhoneNumber

    private val _errorInputEmail = MutableLiveData<Boolean>()
    val errorInputEmail: LiveData<Boolean>
        get() = _errorInputEmail

    private val _errorInputLevelEducation = MutableLiveData<Boolean>()
    val errorInputLevelEducation: LiveData<Boolean>
        get() = _errorInputEmail

    private val _errorInputProWork = MutableLiveData<Boolean>()
    val errorInputProWork: LiveData<Boolean>
        get() = _errorInputProWork

    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen

    private fun parseInputField(fields: String?): String {
        return fields?.trim() ?: ""}

    private fun parseNumber(number: String?): Int {
        return try {
            number?.trim()?.toInt() ?: 0
        } catch (e: Exception) {
            0
        }
    }

    private fun validateInputName(phone:Int,email:String
                                  ,name:String,birthDay:String
                                  ,town:String,proWork:String,level: String):Boolean{
        var result = true
        if (name.isBlank()) {
            _errorInputName.value = true
            result = false
        }
        if (town.isBlank()){
            _errorInputTown.value = true
            result = false
        }
        if (proWork.isBlank()){
            _errorInputProWork.value = true
            result = false
        }
        if (birthDay.isBlank()) {
            _errorInputBirthDay.value = true
            result = false
        }
        if (phone <= 0) {
            _errorInputPhoneNumber.value = true
            result = false
        }
        if (email.isBlank()){
            _errorInputEmail.value = true
            result = false
        }
        if (level.isBlank()){
            _errorInputLevelEducation.value = true
            result = false
        }
        return result
    }

    fun resetErrorInputName() {
        _errorInputName.value = false
    }
    fun resetErrorInputLevel() {
        _errorInputLevelEducation.value = false
    }
    fun resetErrorInputBirthDay() {
        _errorInputBirthDay.value = false
    }
    fun resetErrorInputTown() {
        _errorInputTown.value = false
    }
    fun resetErrorInputPhoneNumber() {
        _errorInputPhoneNumber.value = false
    }
    fun resetErrorInputEmail() {
        _errorInputEmail.value = false
    }
    fun resetErrorInputProWork() {
        _errorInputProWork.value = false
    }
    private fun finishWork() {
        _shouldCloseScreen.value = Unit
    }
}