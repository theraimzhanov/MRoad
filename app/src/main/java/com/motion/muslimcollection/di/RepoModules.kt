package com.motion.muslimcollection.di

import com.motion.muslimcollection.ui.lessons.LessonRepository
import com.motion.muslimcollection.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module


val repoModules: Module = module {
    single { LessonRepository(get()) }
}