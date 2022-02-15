package com.motion.muslimcollection.data.remote

import com.motion.muslimcollection.model.lessoncategories.LessonCategoriesId
import com.motion.muslimcollection.network.BaseDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    factory { RemoteDataSource(get()) }
}

class RemoteDataSource(private val apiService: Service) : BaseDataSource() {

    suspend fun Lesson_Categories_All() = getResult {
        apiService.getLessonCategories()
    }
     suspend fun Lesson_Categories_ID(id:Int) = getResult {
         apiService.getLessonCategoriesID(id)
     }

}
