package com.motion.muslimcollection.ui.lessons
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.motion.muslimcollection.core.base.BaseViewModel
import com.motion.muslimcollection.model.lesson.LessonsItem
import com.motion.muslimcollection.model.lessoncategories.GetLessonCategoriesItem
import com.motion.muslimcollection.network.result.Resource

class LessonViewModel(private val repository: LessonRepository):BaseViewModel() {
    var laodi = MutableLiveData<Boolean>()


    //бул категория обший келет
    private var _kt_list = MutableLiveData<Resource<List<GetLessonCategoriesItem>>>()
    fun getLessonAll() {
        _kt_list = repository.getAllLessonCategories() as MutableLiveData<Resource<List<GetLessonCategoriesItem>>>
    }
    val list: LiveData<Resource<List<GetLessonCategoriesItem>>>
        get() = _kt_list
    //бул катгория айдиси менен келет
    private var _kt_id = MutableLiveData<Resource<GetLessonCategoriesItem>>()
    fun getCategoriaId(id: Int) {
        _kt_id = repository.getCategoriesId(id) as MutableLiveData<Resource<GetLessonCategoriesItem>>
    }
    val item: LiveData<Resource<GetLessonCategoriesItem>>
        get() = _kt_id

   //бул сабактар обший
   private var _all = MutableLiveData<Resource<List<LessonsItem>>>()
    fun getAll() {
        _all = repository.getAllLesson() as MutableLiveData<Resource<List<LessonsItem>>>
    }
    val all: LiveData<Resource<List<LessonsItem>>>
        get() = _all



//бул сабактар айдиси менен
    private var _audio = MutableLiveData<Resource<LessonsItem>>()
    fun getAudioId(id: Int) {
        _audio = repository.getLessonId(id) as MutableLiveData<Resource<LessonsItem>>
    }
    val audioId: LiveData<Resource<LessonsItem>>
        get() = _audio


}