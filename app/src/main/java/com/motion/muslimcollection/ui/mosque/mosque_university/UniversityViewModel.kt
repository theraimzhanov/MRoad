package com.motion.muslimcollection.ui.mosque.mosque_university

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.motion.muslimcollection.core.base.BaseViewModel
import com.motion.muslimcollection.model.address_model.UniversityItem
import com.motion.muslimcollection.network.result.Resource

class UniversityViewModel(private val repository:UniversityRepository):BaseViewModel() {

    var laoding = MutableLiveData<Boolean>()
    private var _list = MutableLiveData<Resource<List<UniversityItem>>>()
    private var _item = MutableLiveData<Resource<UniversityItem>>()

    // get Room List
    fun getUniversityList() {
        _list = repository.getAllUniversity() as MutableLiveData<Resource<List<UniversityItem>>>
    }
    val list: LiveData<Resource<List<UniversityItem>>>
        get() = _list

    // get RoomItem by id
    fun getUniversityItem(id: Int) {
        _item = repository.getUniversityItemByID(id) as MutableLiveData<Resource<UniversityItem>>
    }
    val item: LiveData<Resource<UniversityItem>>
        get() = _item

    // post RoomItem
    fun postUniversityItem(item: UniversityItem) {
        repository.postUniversityItem(item)
    }





}