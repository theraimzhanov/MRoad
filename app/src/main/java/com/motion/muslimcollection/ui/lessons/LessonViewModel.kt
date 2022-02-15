package com.motion.muslimcollection.ui.lessons
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.motion.muslimcollection.core.base.BaseViewModel
import com.motion.muslimcollection.model.lesson.LessonsCategoriesItem
import com.motion.muslimcollection.network.result.Resource

class LessonViewModel(private val repository: LessonRepository):BaseViewModel() {
    var laodi = MutableLiveData<Boolean>()
    private var _lessonId = MutableLiveData<Resource<LessonsCategoriesItem>>()
    private var _lessonAll = MutableLiveData<Resource<List<LessonsCategoriesItem>>>()


     fun lessonAll(){
      _lessonAll = repository.getAllLessonCategories() as MutableLiveData<Resource<List<LessonsCategoriesItem>>>
     }
    fun lessonId(id:Int){
        _lessonId = repository.getCategoriesId(id) as MutableLiveData<Resource<LessonsCategoriesItem>>
    }
    val lessonsAll:LiveData<Resource<List<LessonsCategoriesItem>>>
    get() = _lessonAll

    val lessonsId:LiveData<Resource<LessonsCategoriesItem>>
        get( ) = _lessonId

}