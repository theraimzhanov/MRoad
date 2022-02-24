package com.motion.muslimcollection.ui.mosque.mosque_college

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.motion.muslimcollection.core.base.BaseViewModel
import com.motion.muslimcollection.model.address_model.MosqueCollegeItem
import com.motion.muslimcollection.network.result.Resource

class MosqueCollegeViewModel(private val repository: MosqueCollegeRepository):BaseViewModel() {

    var laoding = MutableLiveData<Boolean>()

    private var _list = MutableLiveData<Resource<List<MosqueCollegeItem>>>()
    private var _item = MutableLiveData<Resource<MosqueCollegeItem>>()

    // get MosqueCollege List
    fun getMosqueCollegeList() {
        _list = repository.getAllMosqueCollege()
                as MutableLiveData<Resource<List<MosqueCollegeItem>>> }
    val list: LiveData<Resource<List<MosqueCollegeItem>>>
        get() = _list

    // get MosqueCollege by id
    fun getMosqueCollegeItem(id: Int) {
        _item = repository.getMosqueCollegeItemByID(id)
                as MutableLiveData<Resource<MosqueCollegeItem>> }
    val item: LiveData<Resource<MosqueCollegeItem>>
        get() = _item

    // post MosqueCollege
    fun postMosqueCollegeItem(mosqueCollegeItem: MosqueCollegeItem) {
        repository.postMosqueCollegeItem(mosqueCollegeItem)
    }

    //delete MosqueCollege
    fun deleteMosqueCollegeItem(id: Int){
        repository.deleteMosqueCollegeItemById(id)
    }
}