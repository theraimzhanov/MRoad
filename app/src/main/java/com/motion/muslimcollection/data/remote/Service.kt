package com.motion.muslimcollection.data.remote

import com.motion.muslimcollection.model.lessoncategories.GetLessonCategoriesItem
import com.motion.muslimcollection.model.lessoncategories.LessonCategoriesId
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {
       //lesson categories
       @GET("/lesson/v1/categories/")
       suspend fun getLessonCategories():Response<List<GetLessonCategoriesItem>>
       //lesson_Categories_id
       @GET("/lesson/v1/categories/{id}/")
       suspend fun getLessonCategoriesID(@Path("id")id:Int):Response<LessonCategoriesId>

}