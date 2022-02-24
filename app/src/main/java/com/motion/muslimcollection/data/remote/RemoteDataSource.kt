package com.motion.muslimcollection.data.remote
import com.motion.muslimcollection.model.address_model.*
import com.motion.muslimcollection.model.cafe_model.CafeItem
import com.motion.muslimcollection.model.cafe_model.FastFoodItem
import com.motion.muslimcollection.model.cafe_model.MagazineItem
import com.motion.muslimcollection.model.cafe_model.RestaurantItem
import com.motion.muslimcollection.model.time_model.LocationItem
import com.motion.muslimcollection.model.time_model.TimeItem
import com.motion.muslimcollection.model.vacancy_model.VacancyItem

import com.motion.muslimcollection.network.BaseDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    factory { RemoteDataSource(get()) }
}
class RemoteDataSource(private val apiService: Service) : BaseDataSource() {

    // request -- get list
    suspend fun getVacancyList() = getResult {
        apiService.getVacancyList()
    }
    suspend fun getAllLesson() = getResult {
        apiService.getLessonAll()
    }
    suspend fun getAllLessonCategory() = getResult {
        apiService.getLessonCategories()
    }
    suspend fun getAllCafes() = getResult {
        apiService.getAllCafes()
    }
    suspend fun getAllMagazines() = getResult {
        apiService.getAllMagazines()
    }
    suspend fun getAllRestaurants() = getResult {
        apiService.getAllRestaurants()
    }
    suspend fun getAllFastFoods() = getResult {
        apiService.getAllFastFoods()
    }
    suspend fun getAllLocation() = getResult {
        apiService.getAllLocations()
    }
    suspend fun getAllTime() = getResult {
        apiService.getAllTime()
    }
    suspend fun getAllMadrasah() = getResult {
        apiService.getAllMadrasah()
    }
    suspend fun getAllMosqueCollege() = getResult {
        apiService.getAllMosqueCollege()
    }
    suspend fun getAllMosque() = getResult {
        apiService.getAllMosqueItem()
    }
    suspend fun getAllMosqueLibrary() = getResult {
        apiService.getAllMosLibrary()
    }
    suspend fun getAllMosqueRoom() = getResult {
        apiService.getAllRoom()
    }

    //  request -- post
    suspend fun postVacancyList(vacancyItem: VacancyItem) = getResult {
        apiService.addVacancyItem(vacancyItem)
    }
    suspend fun postCafeItem(cafeItem: CafeItem) = getResult {
        apiService.postCafeItem(cafeItem)
    }
    suspend fun postFastFoodItem(fastFoodItem: FastFoodItem) = getResult {
        apiService.postFastFoodItem(fastFoodItem)
    }
    suspend fun postMagazineItem(magazineItem: MagazineItem) = getResult {
        apiService.postMagazineItem(magazineItem)
    }
    suspend fun postRestaurantItem(restaurantItem: RestaurantItem) = getResult {
        apiService.postRestaurantItem(restaurantItem)
    }
    suspend fun postLocationItem(locationItem: LocationItem) = getResult {
        apiService.postLocationItem(locationItem)
    }
    suspend fun postTimeItem(timeItem: TimeItem) = getResult {
        apiService.postTimeItem(timeItem)
    }
    suspend fun postMadrasahItem(madrasahItem: MadrasahItem) = getResult {
        apiService.postMadrasahItem(madrasahItem)
    }
    suspend fun postMosqueCollegeItem(mosqueCollegeItem: MosqueCollegeItem) = getResult {
        apiService.postMosCollegeItem(mosqueCollegeItem)
    }
    suspend fun postMosque(mosqueItem: MosqueItem) = getResult {
        apiService.postMosqueItem(mosqueItem)
    }
    suspend fun postMosqueLibrary(mosqueLibraryItem: MosqueLibraryItem) = getResult {
        apiService.postMosLibraryItem(mosqueLibraryItem)
    }
    suspend fun postRoomItem(roomItem: RoomItem) = getResult {
        apiService.postRoomItem(roomItem)
    }

    // request --- get by id & by date
    suspend fun getVacancyItem(id: Int) = getResult {
        apiService.getVacancyItem(id)
    }
    suspend fun getLessonId(id:Int) = getResult {
        apiService.getLessonID(id)
    }
    suspend fun getLessonCategory(id:Int) = getResult {
        apiService.getLessonCategoriesID(id)
    }
    suspend fun getCafeItemById(id: Int) = getResult {
        apiService.getCafeItemByID(id)
    }
    suspend fun getFastFoodItemByID(id: Int) = getResult {
        apiService.getFastFoodItemByID(id)
    }
    suspend fun getMagazineItemById(id: Int) = getResult {
        apiService.getMagazineItemById(id)
    }
    suspend fun getRestaurantItemByID(id: Int) = getResult {
        apiService.getRestaurantItemByID(id)
    }
    suspend fun getLocationItemById(id: Int) = getResult {
        apiService.getLocationItemById(id)
    }
    suspend fun getTimeItemByDate(date: String) = getResult {
        apiService.getTimeItemByDate(date)
    }
    suspend fun getMadrasahItemById(id: Int) = getResult {
        apiService.getMadrasahItemById(id)
    }
    suspend fun getMosqueCollegeItemById(id: Int) = getResult {
        apiService.getMosCollegeItemById(id)
    }
    suspend fun getMosqueItemById(id: Int) = getResult {
        apiService.getMosqueItem(id)
    }
    suspend fun getMosqueLibraryItemById(id: Int) = getResult {
        apiService.getMosLibraryItemById(id)
    }
    suspend fun getRoomItemById(id: Int) = getResult {
        apiService.getRoomItemById(id)
    }
    // cafe request --- delete by id & by date
    suspend fun deleteCafeItemById(id: Int) = getResult {
        apiService.deleteCafeItemById(id)
    }
    suspend fun deleteFastFoodItemByID(id: Int) = getResult {
        apiService.deleteFastFoodItem(id)
    }
    suspend fun deleteMagazineItemById(id: Int) = getResult {
        apiService.deleteMagazineItemByID(id)
    }
    suspend fun deleteRestaurantItemByID(id: Int) = getResult {
        apiService.deleteRestaurants(id)
    }
    suspend fun deleteLocationItemById(id: Int) = getResult {
        apiService.deleteLocationItemById(id)
    }
    suspend fun deleteTimeItemByDate(date: String) = getResult {
        apiService.deleteTimeItemByDate(date)
    }
    suspend fun deleteMadrasahItemById(id: Int) = getResult {
        apiService.deleteMadrasahItemById(id)
    }
    suspend fun deleteMosqueCollegeItemById(id: Int) = getResult {
        apiService.deleteMosCollegeItemById(id)
    }
    suspend fun deleteMosqueItemById(id: Int) = getResult {
        apiService.deleteMosqueItem(id)
    }
    suspend fun deleteMosqueLibraryItemById(id: Int) = getResult {
        apiService.deleteMosLibraryItemById(id)
    }
    suspend fun deleteRoomItemById(id: Int) = getResult {
        apiService.deleteRoomItemById(id)
    }
}
