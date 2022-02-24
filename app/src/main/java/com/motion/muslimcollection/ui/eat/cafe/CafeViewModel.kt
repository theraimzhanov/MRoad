package com.motion.muslimcollection.ui.eat.cafe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.motion.muslimcollection.core.base.BaseViewModel
import com.motion.muslimcollection.model.cafe_model.CafeItem
import com.motion.muslimcollection.network.result.Resource

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
    fun postCafeItem(cafeItem: CafeItem) {
       repository.postCafeItem(cafeItem)
    }

    //delete CafeItem
    fun deleteCafeItem(id: Int){
        repository.deleteCafeItemById(id)
    }
}