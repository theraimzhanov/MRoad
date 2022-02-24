package com.motion.muslimcollection.data.remote

import com.motion.muslimcollection.model.cafe_model.CafeItem
import com.motion.muslimcollection.model.cafe_model.FastFoodItem
import com.motion.muslimcollection.model.cafe_model.MagazineItem
import com.motion.muslimcollection.model.cafe_model.RestaurantItem
import com.motion.muslimcollection.model.lesson_model.LessonItem
import com.motion.muslimcollection.model.address_model.MosqueLibraryItem
import com.motion.muslimcollection.model.address_model.MadrasahItem
import com.motion.muslimcollection.model.address_model.MosqueCollegeItem
import com.motion.muslimcollection.model.address_model.MosqueItem
import com.motion.muslimcollection.model.address_model.RoomItem
import com.motion.muslimcollection.model.lesson_model.CategoryLesson
import com.motion.muslimcollection.model.time_model.LocationItem
import com.motion.muslimcollection.model.time_model.TimeItem
import com.motion.muslimcollection.model.vacancy_model.VacancyItem
import retrofit2.Response
import retrofit2.http.*

interface Service {

    //request for lesson
    @GET("/lesson/v1/categories/")
    suspend fun getLessonCategories(): Response<List<CategoryLesson>>
    @GET("/lesson/v1/categories/{id}/")
    suspend fun getLessonCategoriesID(@Path("id") id: Int): Response<CategoryLesson>
    @GET("/lesson/v1/lessons/")
    suspend fun getLessonAll(): Response<List<LessonItem>>
    @GET("/lesson/v1/lessons/{id}/")
    suspend fun getLessonID(@Path("id") id: Int): Response<LessonItem>

      // request for vacancy
    @GET("/vacancy/v1/vacancies/")
    suspend fun getVacancyList(): Response<List<VacancyItem>>
    @POST("/vacancy/v1/vacancies/")
    suspend fun addVacancyItem(@Body vacancyItem: VacancyItem): Response<VacancyItem>
    @GET("/vacancy/v1/vacancy/{id}/")
    suspend fun getVacancyItem(@Path("id") id: Int): Response<VacancyItem>

    // request for cafe
    @GET("/cafe/v1/cafes/")
    suspend fun getAllCafes(): Response<List<CafeItem>>

    @POST("/cafe/v1/cafes/")
    suspend fun postCafeItem(@Body cafeItem: CafeItem): Response<CafeItem>

    @GET("/cafe/v1/cafes/{id}/")
    suspend fun getCafeItemByID(@Path("id") id: Int): Response<CafeItem>

    @DELETE("/cafe/v1/cafes/{id}/")
    suspend fun deleteCafeItemById(@Path("id") id: Int): Response<CafeItem>

    //request for fast food
    @GET("/cafe/v1/fastfoods/")
    suspend fun getAllFastFoods(): Response<List<FastFoodItem>>

    @POST("/cafe/v1/fastfoods/")
    suspend fun postFastFoodItem(@Body foodItem: FastFoodItem): Response<FastFoodItem>

    @GET("/cafe/v1/fastfoods/{id}/")
    suspend fun getFastFoodItemByID(@Path("id") id: Int): Response<FastFoodItem>

    @DELETE("/cafe/v1/fastfoods/{id}/")
    suspend fun deleteFastFoodItem(@Path("id") id: Int): Response<FastFoodItem>

    //request for magazines
    @GET("/cafe/v1/magazines/")
    suspend fun getAllMagazines(): Response<List<MagazineItem>>

    @POST("/cafe/v1/magazines/")
    suspend fun postMagazineItem(@Body magazineItem: MagazineItem): Response<MagazineItem>

    @GET("/cafe/v1/magazines/{id}/")
    suspend fun getMagazineItemById(@Path("id") id: Int): Response<MagazineItem>

    @DELETE("/cafe/v1/magazines/{id}/")
    suspend fun deleteMagazineItemByID(@Path("id") id: Int): Response<MagazineItem>

    //request for restaurants
    @GET("/cafe/v1/restaurants/")
    suspend fun getAllRestaurants(): Response<List<RestaurantItem>>

    @POST("/cafe/v1/restaurants/")
    suspend fun postRestaurantItem(@Body restaurantItem: RestaurantItem): Response<RestaurantItem>

    @GET("/cafe/v1/restaurants/{id}/")
    suspend fun getRestaurantItemByID(@Path("id") id: Int): Response<RestaurantItem>

    @DELETE("/cafe/v1/restaurants/{id}/")
    suspend fun deleteRestaurants(@Path("id") id: Int): Response<RestaurantItem>

    // request for time
    @GET("/time/v1/locations/")
    suspend fun getAllLocations(): Response<List<LocationItem>>

    @POST("/time/v1/locations/")
    suspend fun postLocationItem(@Body locationItem: LocationItem): Response<LocationItem>

    @GET("/time/v1/locations/{id}/")
    suspend fun getLocationItemById(@Path("id") id: Int): Response<LocationItem>

    @DELETE("/time/v1/locations/{id}/")
    suspend fun deleteLocationItemById(@Path("id") id: Int): Response<LocationItem>

    @GET("/time/v1/times/")
    suspend fun getAllTime(): Response<List<TimeItem>>

    @POST("/time/v1/times/")
    suspend fun postTimeItem(@Body timeItem: TimeItem): Response<TimeItem>

    @GET("/time/v1/times/{date}/")
    suspend fun getTimeItemByDate(@Path("date") date: String): Response<TimeItem>

    @DELETE("/time/v1/times/{date}/")
    suspend fun deleteTimeItemByDate(@Path("date") date: String): Response<TimeItem>

    //request for address
    @GET("/address/v1/mosque_colleges/")
    suspend fun getAllMosqueCollege(): Response<List<MosqueCollegeItem>>

    @POST("/address/v1/mosque_colleges/")
    suspend fun postMosCollegeItem(@Body item: MosqueCollegeItem): Response<MosqueCollegeItem>

    @GET("/address/v1/mosque_colleges/{id}/")
    suspend fun getMosCollegeItemById(@Path("id") id: Int): Response<MosqueCollegeItem>

    @DELETE("/address/v1/mosque_colleges/{id}/")
    suspend fun deleteMosCollegeItemById(@Path("id") id: Int): Response<MosqueCollegeItem>

    @GET("/address/v1/mosque_libraries/")
    suspend fun getAllMosLibrary(): Response<List<MosqueLibraryItem>>

    @POST("/address/v1/mosque_libraries/")
    suspend fun postMosLibraryItem(@Body item: MosqueLibraryItem): Response<MosqueLibraryItem>

    @GET("/address/v1/mosque_libraries/{id}/")
    suspend fun getMosLibraryItemById(@Path("id") id: Int): Response<MosqueLibraryItem>

    @DELETE("/address/v1/mosque_libraries/{id}/")
    suspend fun deleteMosLibraryItemById(@Path("id") id: Int): Response<MosqueLibraryItem>

    @GET("/address/v1/mosque_madrasahs/")
    suspend fun getAllMadrasah(): Response<List<MadrasahItem>>

    @POST("/address/v1/mosque_madrasahs/")
    suspend fun postMadrasahItem(@Body item: MadrasahItem): Response<MadrasahItem>

    @GET("/address/v1/mosque_madrasahs/{id}/")
    suspend fun getMadrasahItemById(@Path("id") id: Int): Response<MadrasahItem>

    @DELETE("/address/v1/mosque_madrasahs/{id}/")
    suspend fun deleteMadrasahItemById(@Path("id") id: Int): Response<MadrasahItem>

    @GET("/address/v1/mosque_rooms/")
    suspend fun getAllRoom(): Response<List<RoomItem>>

    @POST("/address/v1/mosque_rooms/")
    suspend fun postRoomItem(@Body item: RoomItem): Response<RoomItem>

    @GET("/address/v1/mosque_rooms/{id}/")
    suspend fun getRoomItemById(@Path("id") id: Int): Response<RoomItem>

    @DELETE("/address/v1/mosque_rooms/{id}/")
    suspend fun deleteRoomItemById(@Path("id") id: Int): Response<RoomItem>


    @GET("/address/v1/mosques/")
    suspend fun getAllMosqueItem(): Response<List<MosqueItem>>

    @POST("/address/v1/mosques/")
    suspend fun postMosqueItem(@Body item: MosqueItem): Response<MosqueItem>

    @GET("/address/v1/mosques/{id}/")
    suspend fun getMosqueItem(@Path("id") id: Int): Response<MosqueItem>

    @DELETE("/address/v1/mosques/{id}/")
    suspend fun deleteMosqueItem(@Path("id") id: Int): Response<MosqueItem>


}