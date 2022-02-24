package com.motion.muslimcollection.ui.vacancy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.motion.muslimcollection.core.base.BaseViewModel
import com.motion.muslimcollection.model.vacancy_model.VacancyItem
import com.motion.muslimcollection.network.result.Resource

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
    fun addVacancyItem(name:String?,company:String?
                       ,requirements:String,salary:String?
                       ,obligation:String?,religion:String?) {
         val nameOfVacancy = parseInputField(name)
         val companyOfVacancy = parseInputField(company)
         val requirementsOfVacancy = parseInputField(requirements)
         val salaryOfVacancy = parseSalary(salary)
         val obligationOfVacancy = parseInputField(obligation)
         val religionOfVacancy = parseInputField(religion)
        val fieldsValid = validateInputName(nameOfVacancy,companyOfVacancy
            ,requirementsOfVacancy,salaryOfVacancy,obligationOfVacancy,religionOfVacancy)
        if (fieldsValid){
val vacancy = VacancyItem(nameOfVacancy,companyOfVacancy,requirementsOfVacancy,religionOfVacancy
    ,obligationOfVacancy, salary = salaryOfVacancy)
            _add = repository.addVacancyItem(vacancy) as MutableLiveData<Resource<VacancyItem>>
            finishWork()
        }
    }
    val add: LiveData<Resource<VacancyItem>>
        get() = _add

    private val _errorInputName = MutableLiveData<Boolean>()
    val errorInputName: LiveData<Boolean>
        get() = _errorInputName

    private val _errorInputCompany = MutableLiveData<Boolean>()
    val errorInputCompany: LiveData<Boolean>
        get() = _errorInputCompany

    private val _errorInputRequirements = MutableLiveData<Boolean>()
    val errorInputRequirements: LiveData<Boolean>
        get() = _errorInputRequirements

    private val _errorInputSalary = MutableLiveData<Boolean>()
    val errorInputSalary: LiveData<Boolean>
        get() = _errorInputSalary

    private val _errorInputObligation = MutableLiveData<Boolean>()
    val errorInputObligation: LiveData<Boolean>
        get() = _errorInputObligation

    private val _errorInputReligion = MutableLiveData<Boolean>()
    val errorInputReligion: LiveData<Boolean>
        get() = _errorInputReligion

    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen

    private fun parseInputField(fields: String?): String {
        return fields?.trim() ?: ""}

    private fun parseSalary(salary: String?): Int {
        return try {
            salary?.trim()?.toInt() ?: 0
        } catch (e: Exception) {
            0
        }
    }

    private fun validateInputName(name:String,company:String
                                  ,requirements:String,salary:Int
                                  ,obligation:String,religion:String):Boolean{
        var result = true
        if (name.isBlank()) {
            _errorInputName.value = true
            result = false
        }
        if (company.isBlank()){
            _errorInputCompany.value = true
            result = false
        }
        if (requirements.isBlank()){
            _errorInputRequirements.value = true
            result = false
        }
        if (salary <= 0) {
            _errorInputSalary.value = true
            result = false
        }
        if (obligation.isBlank()){
            _errorInputObligation.value = true
            result = false
        }
        if (religion.isBlank()){
            _errorInputReligion.value = true
            result = false
        }
        return result
    }

    fun resetErrorInputName() {
        _errorInputName.value = false
    }
    fun resetErrorInputCompany() {
        _errorInputCompany.value = false
    }
    fun resetErrorInputRequirements() {
        _errorInputRequirements.value = false
    }
    fun resetErrorInputSalary() {
        _errorInputSalary.value = false
    }
    fun resetErrorInputObligation() {
        _errorInputObligation.value = false
    }
    fun resetErrorInputReligion() {
        _errorInputReligion.value = false
    }
    private fun finishWork() {
        _shouldCloseScreen.value = Unit
    }
}