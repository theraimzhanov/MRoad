package com.motion.muslimcollection.ui.lessons
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.motion.muslimcollection.core.base.BaseViewModel
import com.motion.muslimcollection.model.lessoncategories.GetLessonCategoriesItem
import com.motion.muslimcollection.model.vacancies.VacancyItem
import com.motion.muslimcollection.network.result.Resource

class LessonViewModel(private val repository: LessonRepository):BaseViewModel() {


    var laodi = MutableLiveData<Boolean>()
    private var _lesson = MutableLiveData<Resource<GetLessonCategoriesItem>>()
    fun getLessonId(id: Int) {
        _lesson = repository.getCategoriesId(id) as MutableLiveData<Resource<GetLessonCategoriesItem>>
    }

    val item: LiveData<Resource<GetLessonCategoriesItem>>
        get() = _lesson

    // get Vacancy List
    private var _list = MutableLiveData<Resource<List<GetLessonCategoriesItem>>>()
    fun getLessonAll() {
        _list =
            repository.getAllLessonCategories() as MutableLiveData<Resource<List<GetLessonCategoriesItem>>>
    }

    val list: LiveData<Resource<List<GetLessonCategoriesItem>>>
        get() = _list
}