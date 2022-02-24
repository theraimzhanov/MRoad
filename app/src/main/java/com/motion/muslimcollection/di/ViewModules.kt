package com.motion.muslimcollection.di


import com.motion.muslimcollection.ui.eat.cafe.CafeViewModel
import com.motion.muslimcollection.ui.eat.fastfood.FastFoodViewModel
import com.motion.muslimcollection.ui.eat.magazine.MagazineViewModel
import com.motion.muslimcollection.ui.eat.restaurant.RestaurantViewModel
import com.motion.muslimcollection.ui.homefragment.TimeViewModel
import com.motion.muslimcollection.ui.lessons.LessonViewModel
import com.motion.muslimcollection.ui.main.MainViewModel
import com.motion.muslimcollection.ui.mosque.mosques.MosqueViewModel
import com.motion.muslimcollection.ui.mosque.mosque_college.MosqueCollegeViewModel
import com.motion.muslimcollection.ui.mosque.mosque_library.LibraryViewModel
import com.motion.muslimcollection.ui.mosque.mosque_madrasah.MadrasahViewModel
import com.motion.muslimcollection.ui.mosque.mosque_room.RoomViewModel

import com.motion.muslimcollection.ui.vacancy.VacancyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModules: Module = module {
    viewModel { MainViewModel() }
    viewModel { LessonViewModel(get()) }
    viewModel { VacancyViewModel(get()) }
    viewModel { CafeViewModel(get() ) }
    viewModel { FastFoodViewModel(get()) }
    viewModel { MagazineViewModel(get()) }
    viewModel { RestaurantViewModel(get()) }
    viewModel { TimeViewModel(get()) }
    viewModel { MosqueCollegeViewModel(get()) }
    viewModel { LibraryViewModel(get()) }
    viewModel { MadrasahViewModel(get()) }
    viewModel { RoomViewModel(get()) }
    viewModel { MosqueViewModel(get()) }
}
