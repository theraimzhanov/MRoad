package com.motion.muslimcollection.data.remote

import com.motion.muslimcollection.model.address_model.*
import com.motion.muslimcollection.model.lesson_model.LessonItem
import com.motion.muslimcollection.model.cafe_model.*
import com.motion.muslimcollection.model.lesson_model.CategoryLesson
import com.motion.muslimcollection.model.time_model.LocationItem
import com.motion.muslimcollection.model.time_model.TimeItem
import com.motion.muslimcollection.model.vacancy_model.VacancyItem
import retrofit2.Response
import retrofit2.http.*

interface Service {

    //request for lesson
    @GET("/categories/")
    suspend fun getLessonCategories(): Response<List<CategoryLesson>>

    @GET("/categories/{id}/")
    suspend fun getLessonCategoriesID(@Path("id") id: Int): Response<CategoryLesson>

    @GET("/lessons/")
    suspend fun getLessonAll(): Response<List<LessonItem>>

    @GET("/lessons/{id}/")
    suspend fun getLessonID(@Path("id") id: Int): Response<LessonItem>

    // request for vacancy
    @GET("/vacancy/v1/vacancies/")
    suspend fun getVacancyList(): Response<List<VacancyItem>>

    @POST("/vacancy/v1/vacancies/")
    suspend fun addVacancyItem(@Body vacancyItem: VacancyItem): Response<VacancyItem>

    @GET("/vacancy/v1/vacancy/{id}/")
    suspend fun getVacancyItem(@Path("id") id: Int): Response<VacancyItem>

    // request for cafe setting

    @GET("/cafe-list/")
    suspend fun getAllCafes(): Response<List<CafeItem>>

    @POST("/cafe-create/")
    suspend fun postCafeItem(@Body cafeItem: CafeItemV): Response<CafeItemV>

    @GET("/cafe-detail/{id}/")
    suspend fun getCafeItemByID(@Path("id") id: Int): Response<CafeItem>

    @DELETE("/cafe/v1/cafes/{id}/")
    suspend fun deleteCafeItemById(@Path("id") id: Int): Response<CafeItem>

    //request for fast food
    @GET("/fastfood-list/")
    suspend fun getAllFastFoods(): Response<List<FastFoodItem>>

    @POST("/fastfood-create/")
    suspend fun postFastFoodItem(@Body foodItem: FastFoodItem): Response<FastFoodItem>

    @GET("/fastfood-detail/{id}/")
    suspend fun getFastFoodItemByID(@Path("id") id: Int): Response<FastFoodItem>

    @DELETE("/fastfood-list/")
    suspend fun deleteFastFoodItem(@Path("id") id: Int): Response<FastFoodItem>

    //request for magazines
    @GET("/magazine-list/")
    suspend fun getAllMagazines(): Response<List<MagazineItem>>

    @POST("/magazine-create/")
    suspend fun postMagazineItem(@Body magazineItem: MagazineItem): Response<MagazineItem>

    @GET("/magazine-detail/{id}/")
    suspend fun getMagazineItemById(@Path("id") id: Int): Response<MagazineItem>

    @DELETE("/cafe/v1/magazines/{id}/")
    suspend fun deleteMagazineItemByID(@Path("id") id: Int): Response<MagazineItem>


    //request for restaurants
    @GET("/restaurant-list/")
    suspend fun getAllRestaurants(): Response<List<RestaurantItem>>

    @POST("/restaurant-create/")
    suspend fun postRestaurantItem(@Body restaurantItem: RestaurantItem): Response<RestaurantItem>

    @GET("/restaurant-detail/{id}/")
    suspend fun getRestaurantItemByID(@Path("id") id: Int): Response<RestaurantItem>

    @DELETE("")
    suspend fun deleteRestaurants(@Path("id") id: Int): Response<RestaurantItem>

    // request for time
    @GET("/times/")
    suspend fun getAllLocations(): Response<List<LocationItem>>

    @POST("/times/")
    suspend fun postLocationItem(@Body locationItem: LocationItem): Response<LocationItem>

    @GET("/times/{date}/")
    suspend fun getLocationItemById(@Path("id") id: Int): Response<LocationItem>

    @DELETE("/time/v1/locations/{id}/")
    suspend fun deleteLocationItemById(@Path("id") id: Int): Response<LocationItem>

    @GET("/times/")
    suspend fun getAllTime(): Response<List<TimeItem>>

    @POST("/times/")
    suspend fun postTimeItem(@Body timeItem: TimeItem): Response<TimeItem>

    @GET("/times/{date}/")
    suspend fun getTimeItemByDate(@Path("date") date: String): Response<TimeItem>

    @DELETE("/time/v1/times/{date}/")
    suspend fun deleteTimeItemByDate(@Path("date") date: String): Response<TimeItem>

    //request for address
    @GET("/mosque_colleges/")
    suspend fun getAllMosqueCollege(): Response<List<MosqueCollegeItem>>

    @POST("/mosque_colleges/")
    suspend fun postMosCollegeItem(@Body item: MosqueCollegeItem): Response<MosqueCollegeItem>

    @GET("/mosque_colleges/{id}/")
    suspend fun getMosCollegeItemById(@Path("id") id: Int): Response<MosqueCollegeItem>

    @DELETE("/address/v1/mosque_colleges/{id}/")
    suspend fun deleteMosCollegeItemById(@Path("id") id: Int): Response<MosqueCollegeItem>

    @GET("/mosque_libraries/")
    suspend fun getAllMosLibrary(): Response<List<MosqueLibraryItem>>

    @POST("/mosque_libraries/")
    suspend fun postMosLibraryItem(@Body item: MosqueLibraryItem): Response<MosqueLibraryItem>

    @GET("/mosque_libraries/{id}/")
    suspend fun getMosLibraryItemById(@Path("id") id: Int): Response<MosqueLibraryItem>

    @DELETE("/address/v1/mosque_libraries/{id}/")
    suspend fun deleteMosLibraryItemById(@Path("id") id: Int): Response<MosqueLibraryItem>

    @GET("/mosque_madrasahs/")
    suspend fun getAllMadrasah(): Response<List<MadrasahItem>>

    @POST("/mosque_madrasahs/")
    suspend fun postMadrasahItem(@Body item: MadrasahItem): Response<MadrasahItem>

    @GET("/mosque_madrasahs/{id}/")
    suspend fun getMadrasahItemById(@Path("id") id: Int): Response<MadrasahItem>

    @DELETE("/address/v1/mosque_madrasahs/{id}/")
    suspend fun deleteMadrasahItemById(@Path("id") id: Int): Response<MadrasahItem>

    @GET("/mosque_rooms/")
    suspend fun getAllRoom(): Response<List<RoomItem>>

    @POST("/mosque_rooms/")
    suspend fun postRoomItem(@Body item: RoomItem): Response<RoomItem>

    @GET("/mosque_rooms/{id}/")
    suspend fun getRoomItemById(@Path("id") id: Int): Response<RoomItem>

    @DELETE("/address/v1/mosque_rooms/{id}/")
    suspend fun deleteRoomItemById(@Path("id") id: Int): Response<RoomItem>


    @GET("/mosques/")
    suspend fun getAllMosqueItem(): Response<List<MosqueItem>>

    @POST("/mosques/")
    suspend fun postMosqueItem(@Body item: MosqueItem): Response<MosqueItem>

    @GET("/mosques/{id}/")
    suspend fun getMosqueItem(@Path("id") id: Int): Response<MosqueItem>

    @DELETE("/address/v1/mosques/{id}/")
    suspend fun deleteMosqueItem(@Path("id") id: Int): Response<MosqueItem>

    //university
    @GET("/muslim-list/")
    suspend fun getAllUniversityItem(): Response<List<UniversityItem>>

    @POST("/muslim-create/")
    suspend fun postUniversityItem(@Body item: UniversityItem): Response<UniversityItem>

    @GET("/muslim-detail/{id}/")
    suspend fun getIDUniversityItem(@Path("id") id: Int): Response<UniversityItem>

}