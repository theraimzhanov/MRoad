package com.motion.muslimcollection.ui.mosque.mosque_library

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.motion.muslimcollection.core.base.BaseViewModel
import com.motion.muslimcollection.model.address_model.MosqueLibraryItem
import com.motion.muslimcollection.network.result.Resource

class LibraryViewModel(private val repository: LibraryRepository):BaseViewModel() {


    var laoding = MutableLiveData<Boolean>()

    private var _list = MutableLiveData<Resource<List<MosqueLibraryItem>>>()
    private var _item = MutableLiveData<Resource<MosqueLibraryItem>>()

    // get Library List
    fun getLibraryList() {
        _list = repository.getAllLibrary() as MutableLiveData<Resource<List<MosqueLibraryItem>>>
    }
    val list: LiveData<Resource<List<MosqueLibraryItem>>>
        get() = _list

    // get MosqueLibraryItem by id
    fun getLibraryItem(id: Int) {
        _item = repository.getLibraryItemByID(id) as MutableLiveData<Resource<MosqueLibraryItem>>
    }
    val item: LiveData<Resource<MosqueLibraryItem>>
        get() = _item

    // post MosqueLibraryItem
    fun postLibraryItem(library: MosqueLibraryItem) {
        repository.postLibraryItem(library)
    }

    //delete MosqueLibraryItem
    fun deleteLibraryItem(id: Int){
        repository.deleteLibraryItemById(id)
    }
}