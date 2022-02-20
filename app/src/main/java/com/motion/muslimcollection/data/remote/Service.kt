package com.motion.muslimcollection.data.remote
import com.motion.muslimcollection.model.lesson.LessonsItem
import com.motion.muslimcollection.model.lessoncategories.GetLessonCategoriesItem
import com.motion.muslimcollection.model.vacancies.VacancyItem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Service {
       //lesson categories
       @GET("/lesson/v1/categories/")
       suspend fun getLessonCategories():Response<List<GetLessonCategoriesItem>>
       //lesson_Categories_id
       @GET("/lesson/v1/categories/{id}/")
       suspend fun getLessonCategoriesID(@Path("id")id:Int):Response<GetLessonCategoriesItem>
       //сабактар
       @GET("/lesson/v1/lessons/")
       suspend fun getLessonAll():Response<List<LessonsItem>>
       //сабактар айдиси менен
       @GET("/lesson/v1/lessons/{id}/")
       suspend fun getLessonID(@Path("id")id:Int):Response<LessonsItem>

       @GET("/vacancy/v1/vacancies/")
       suspend fun getVacancyList():Response<List<VacancyItem>>

       @POST("/vacancy/v1/vacancies/")
       suspend fun addVacancyItem(@Body vacancyItem: VacancyItem):Response<VacancyItem>

       @GET("/vacancy/v1/vacancy/{id}/")
       suspend fun getVacancyItem(@Path("id") id: Int):Response<VacancyItem>
}