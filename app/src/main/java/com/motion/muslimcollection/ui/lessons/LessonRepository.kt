package com.motion.muslimcollection.ui.lessons

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData

import com.motion.muslimcollection.data.remote.RemoteDataSource
import com.motion.muslimcollection.model.lesson_model.CategoryLesson
import com.motion.muslimcollection.model.lesson_model.LessonItem
import com.motion.muslimcollection.network.result.Resource
import kotlinx.coroutines.Dispatchers

class LessonRepository(private val remoteDataSource: RemoteDataSource) {
///
    fun getAllLessonCategories(): LiveData<Resource<List<CategoryLesson>>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading(null))
            emit(remoteDataSource.getAllLessonCategory())
        }

    fun getCategoriesId(id: Int): LiveData<Resource<CategoryLesson>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading(null))
            val result = remoteDataSource.getLessonCategory(id)
            emit(result)
        }

    ////


   fun getAllLesson(): LiveData<Resource<List<LessonItem>>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading(null))
            emit(remoteDataSource.getAllLesson())
        }



    fun getLessonId(id: Int): LiveData<Resource<LessonItem>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading(null))
            val result = remoteDataSource.getLessonId(id)
            emit(result)
        }

}