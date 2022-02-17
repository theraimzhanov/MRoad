package com.motion.muslimcollection.ui.lessons
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.motion.muslimcollection.core.base.BaseViewModel
import com.motion.muslimcollection.model.lessoncategories.GetLessonCategoriesItem
import com.motion.muslimcollection.network.result.Resource

class LessonViewModel(private val repository: LessonRepository):BaseViewModel() {
    var laodi = MutableLiveData<Boolean>()
    private var _lessonId = MutableLiveData<Resource<GetLessonCategoriesItem>>()
    private var _lessonAll = MutableLiveData<Resource<List<GetLessonCategoriesItem>>>()
     fun lessonAll(){
      _lessonAll = repository.getAllLessonCategories() as MutableLiveData<Resource<List<GetLessonCategoriesItem>>>
     }
    fun lessonId(id:Int){
        _lessonId = repository.getCategoriesId(id) as MutableLiveData<Resource<GetLessonCategoriesItem>>
    }
    val lessonsAll:LiveData<Resource<List<GetLessonCategoriesItem>>>
    get() = _lessonAll

    val lessonsId:LiveData<Resource<GetLessonCategoriesItem>>
        get( ) = _lessonId

}