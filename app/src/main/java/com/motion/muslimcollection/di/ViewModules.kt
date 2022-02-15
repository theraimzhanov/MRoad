package com.motion.muslimcollection.di


import com.motion.muslimcollection.ui.lessons.LessonViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModules: Module = module {
    viewModel { LessonViewModel(get()) }
}


