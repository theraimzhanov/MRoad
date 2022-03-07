package com.motion.muslimcollection.ui.home_fragment

import android.app.Application
import androidx.lifecycle.*
import com.motion.muslimcollection.core.base.BaseViewModel
import com.motion.muslimcollection.model.time_model.TimeItem
import com.motion.muslimcollection.network.result.Resource
import kotlinx.coroutines.launch

class TimeViewModel(private val repository: TimeRepository): BaseViewModel() {

    var laoding = MutableLiveData<Boolean>()

    // get Time by date
    private var _item = MutableLiveData<Resource<TimeItem>>()
     fun getTimeItem(date:String) {
         _item =   repository.getTimeItemByDate(date) as MutableLiveData<Resource<TimeItem>>
        }
    val item:LiveData<Resource<TimeItem>>
    get() = _item

}