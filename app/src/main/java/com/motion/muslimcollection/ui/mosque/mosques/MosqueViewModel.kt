package com.motion.muslimcollection.ui.mosque.mosques

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.motion.muslimcollection.core.base.BaseViewModel
import com.motion.muslimcollection.model.address_model.MosqueItem
import com.motion.muslimcollection.network.result.Resource

class MosqueViewModel(private val repository: MosqueRepository):BaseViewModel() {


    var laoding = MutableLiveData<Boolean>()


    private var _list = MutableLiveData<Resource<List<MosqueItem>>>()
    private var _item = MutableLiveData<Resource<MosqueItem>>()

    // get MosqueItem List
    fun getMosqueList() {
        _list = repository.getAllMosque() as MutableLiveData<Resource<List<MosqueItem>>>
    }
    val list: LiveData<Resource<List<MosqueItem>>>
        get() = _list

    // get MosqueItem by id
    fun getMosqueItem(id: Int) {
        _item = repository.getMosqueItemByID(id) as MutableLiveData<Resource<MosqueItem>>
    }
    val item: LiveData<Resource<MosqueItem>>
        get() = _item

    // post MosqueItem
    fun postMosqueItem(mosqueItem: MosqueItem) {
        repository.postMosqueItem(mosqueItem)
    }

    //delete MosqueItem
    fun deleteMosqueItem(id: Int){
        repository.deleteMosqueItemById(id)
    }
}