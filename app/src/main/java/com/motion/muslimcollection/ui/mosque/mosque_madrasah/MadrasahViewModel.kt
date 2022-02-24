package com.motion.muslimcollection.ui.mosque.mosque_madrasah

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.motion.muslimcollection.core.base.BaseViewModel
import com.motion.muslimcollection.model.address_model.MadrasahItem
import com.motion.muslimcollection.network.result.Resource

class MadrasahViewModel(private val repository: MadrasahRepository):BaseViewModel() {
    var laoding = MutableLiveData<Boolean>()


    private var _list = MutableLiveData<Resource<List<MadrasahItem>>>()
    private var _item = MutableLiveData<Resource<MadrasahItem>>()

    // get MadrasahItem List
    fun getMadrasahList() {
        _list = repository.getAllMadrasah() as MutableLiveData<Resource<List<MadrasahItem>>>
    }
    val list: LiveData<Resource<List<MadrasahItem>>>
        get() = _list

    // get MadrasahItem by id
    fun getMadrasahItem(id: Int) {
        _item = repository.getMadrasahItemByID(id) as MutableLiveData<Resource<MadrasahItem>>
    }
    val item: LiveData<Resource<MadrasahItem>>
        get() = _item

    // post MadrasahItem
    fun postMadrasahItem(item: MadrasahItem) {
        repository.postMadrasahItem(item)
    }

    //delete MadrasahItem
    fun deleteMadrasahItem(id: Int){
        repository.deleteMadrasahItemById(id)
    }
}