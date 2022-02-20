package com.motion.muslimcollection.ui.lessons

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData

import com.motion.muslimcollection.data.remote.RemoteDataSource
import com.motion.muslimcollection.model.lesson.LessonsItem
import com.motion.muslimcollection.model.lessoncategories.GetLessonCategoriesItem
import com.motion.muslimcollection.network.result.Resource
import kotlinx.coroutines.Dispatchers

class LessonRepository(private val remoteDataSource: RemoteDataSource) {
///
    fun getAllLessonCategories(): LiveData<Resource<List<GetLessonCategoriesItem>>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading(null))
            emit(remoteDataSource.LessonAllCategories())
        }

    fun getCategoriesId(id: Int): LiveData<Resource<GetLessonCategoriesItem>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading(null))
            val result = remoteDataSource.Lesson_Categories_ID(id)
            emit(result)
        }

    ////


   fun getAllLesson(): LiveData<Resource<List<LessonsItem>>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading(null))
            emit(remoteDataSource.LessonAll())
        }



    fun getLessonId(id: Int): LiveData<Resource<LessonsItem>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading(null))
            val result = remoteDataSource.getLessonId(id)
            emit(result)
        }

}