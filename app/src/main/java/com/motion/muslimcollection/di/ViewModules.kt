package com.motion.muslimcollection.di


import com.motion.muslimcollection.ui.lessons.LessonViewModel
import com.motion.muslimcollection.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModules: Module = module {
    viewModel { MainViewModel() }
    viewModel { LessonViewModel(get()) }
}


