package com.motion.muslimcollection.di


import com.motion.muslimcollection.ui.lessons.LessonRepository
import com.motion.muslimcollection.ui.eat.cafe.CafeRepository
import com.motion.muslimcollection.ui.eat.fastfood.FastFoodRepository
import com.motion.muslimcollection.ui.eat.magazine.MagazineRepository
import com.motion.muslimcollection.ui.eat.restaurant.RestaurantRepository
import com.motion.muslimcollection.ui.homefragment.TimeRepository
import com.motion.muslimcollection.ui.mosque.mosques.MosqueRepository
import com.motion.muslimcollection.ui.mosque.mosque_college.MosqueCollegeRepository
import com.motion.muslimcollection.ui.mosque.mosque_library.LibraryRepository
import com.motion.muslimcollection.ui.mosque.mosque_madrasah.MadrasahRepository
import com.motion.muslimcollection.ui.mosque.mosque_room.RoomRepository
import com.motion.muslimcollection.ui.vacancy.VacancyRepository
import org.koin.core.module.Module
import org.koin.dsl.module


val repoModules: Module = module {

    single { LessonRepository(get()) }
     single { CafeRepository(get()) }
    single { VacancyRepository(get()) }
    single { FastFoodRepository(get()) }
    single { RestaurantRepository(get()) }
    single { MagazineRepository(get()) }
    single { TimeRepository(get()) }
    single { MosqueCollegeRepository(get()) }
    single { LibraryRepository(get()) }
    single { MadrasahRepository(get()) }
    single { RoomRepository(get()) }
    single { MosqueRepository(get()) }

}