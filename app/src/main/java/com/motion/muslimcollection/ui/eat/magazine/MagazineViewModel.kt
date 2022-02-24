package com.motion.muslimcollection.ui.eat.magazine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.motion.muslimcollection.core.base.BaseViewModel
import com.motion.muslimcollection.model.cafe_model.MagazineItem
import com.motion.muslimcollection.network.result.Resource
import com.motion.muslimcollection.ui.eat.fastfood.FastFoodRepository

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
    fun postMagazineItem(magazineItem: MagazineItem) {
        repository.postMagazineItem(magazineItem)
    }

    //delete Magazine Item by id
    fun deleteMagazineItem(id: Int){
        repository.deleteMagazineItemById(id)
    }
}