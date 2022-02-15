package com.motion.muslimcollection.ui.lessons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.motion.muslimcollection.core.base.BaseViewModel
import com.motion.muslimcollection.model.lessoncategories.GetLessonCategoriesItem
import com.motion.muslimcollection.model.lessoncategories.LessonCategoriesId
import com.motion.muslimcollection.network.result.Resource

class LessonViewModel(private val repository: LessonRepository) : BaseViewModel() {
    var load = MutableLiveData<Boolean>()
    private var _lessoncategories = MutableLiveData<Resource<List<GetLessonCategoriesItem>>>()
    private var __lessoncategoriesID = MutableLiveData<Resource<LessonCategoriesId>>()

    fun getLessCategories() {
        _lessoncategories =
            repository.getAllLessonCategories() as MutableLiveData<Resource<List<GetLessonCategoriesItem>>>
    }

    fun getLessCategoriesID(id: Int) {
        __lessoncategoriesID =
            repository.getLessonCategoriesId(id) as MutableLiveData<Resource<LessonCategoriesId>>
    }

    val getLessCategor: LiveData<Resource<List<GetLessonCategoriesItem>>>
        get() = _lessoncategories

     val getLessCategorId:LiveData<Resource<LessonCategoriesId>>
     get() = __lessoncategoriesID
}