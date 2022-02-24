package com.motion.muslimcollection.ui.lessons
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.motion.muslimcollection.core.base.BaseViewModel
import com.motion.muslimcollection.model.lesson_model.CategoryLesson
import com.motion.muslimcollection.model.lesson_model.LessonItem
import com.motion.muslimcollection.network.result.Resource

class LessonViewModel(private val repository: LessonRepository):BaseViewModel() {
    var laodi = MutableLiveData<Boolean>()


    //бул категория обший келет
    private var _kt_list = MutableLiveData<Resource<List<CategoryLesson>>>()
    fun getLessonAll() {
        _kt_list = repository.getAllLessonCategories() as MutableLiveData<Resource<List<CategoryLesson>>>
    }
    val list: LiveData<Resource<List<CategoryLesson>>>
        get() = _kt_list
    //бул катгория айдиси менен келет
    private var _kt_id = MutableLiveData<Resource<CategoryLesson>>()
    fun getCategoriaId(id: Int) {
        _kt_id = repository.getCategoriesId(id) as MutableLiveData<Resource<CategoryLesson>>
    }
    val item: LiveData<Resource<CategoryLesson>>
        get() = _kt_id

   //бул сабактар обший
   private var _all = MutableLiveData<Resource<List<LessonItem>>>()
    fun getAll() {
        _all = repository.getAllLesson() as MutableLiveData<Resource<List<LessonItem>>>
    }
    val all: LiveData<Resource<List<LessonItem>>>
        get() = _all



//бул сабактар айдиси менен
    private var _audio = MutableLiveData<Resource<LessonItem>>()
    fun getAudioId(id: Int) {
        _audio = repository.getLessonId(id) as MutableLiveData<Resource<LessonItem>>
    }
    val audioId: LiveData<Resource<LessonItem>>
        get() = _audio


}