package com.motion.muslimcollection.ui.mosque.mosque_room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.motion.muslimcollection.core.base.BaseViewModel
import com.motion.muslimcollection.model.address_model.RoomItem
import com.motion.muslimcollection.network.result.Resource

class RoomViewModel(private val repository: RoomRepository): BaseViewModel() {

    var laoding = MutableLiveData<Boolean>()
    private var _list = MutableLiveData<Resource<List<RoomItem>>>()
    private var _item = MutableLiveData<Resource<RoomItem>>()

    // get Room List
    fun getRoomList() {
        _list = repository.getAllRoom() as MutableLiveData<Resource<List<RoomItem>>>
    }
    val list: LiveData<Resource<List<RoomItem>>>
        get() = _list

    // get RoomItem by id
    fun getRoomItem(id: Int) {
        _item = repository.getRoomItemByID(id) as MutableLiveData<Resource<RoomItem>>
    }
    val item: LiveData<Resource<RoomItem>>
        get() = _item

    // post RoomItem
    fun postRoomItem(item: RoomItem) {
        repository.postRoomItem(item)
    }

    //delete RoomItem
    fun deleteRoomItem(id: Int){
        repository.deleteRoomItemById(id)
    }
}