package com.motion.muslimcollection.data.remote
import com.motion.muslimcollection.model.vacancies.VacancyItem

import com.motion.muslimcollection.network.BaseDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    factory { RemoteDataSource(get()) }
}
class RemoteDataSource(private val apiService: Service) : BaseDataSource() {
    //бул катгория
    suspend fun LessonAllCategories() = getResult {
        apiService.getLessonCategories()
    }
    //бул катгория айдиси менен
     suspend fun Lesson_Categories_ID(id:Int) = getResult {
         apiService.getLessonCategoriesID(id)
     }
    //бул сабактар
    suspend fun LessonAll() = getResult {
        apiService.getLessonAll()
    }
    //бул сабактар айдиси менен
    suspend fun getLessonId(id:Int) = getResult {
        apiService.getLessonID(id)
    }

    suspend fun getVacancyList() = getResult {
        apiService.getVacancyList()
    }
    suspend fun getVacancyItem(id: Int) = getResult {
        apiService.getVacancyItem(id)
    }
    suspend fun addVacancyList(vacancyItem: VacancyItem) = getResult {
        apiService.addVacancyItem(vacancyItem)
    }

}
