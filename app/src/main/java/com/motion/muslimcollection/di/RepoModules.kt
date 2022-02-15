package com.motion.muslimcollection.di

import com.motion.muslimcollection.ui.lessons.LessonRepository
import org.koin.core.module.Module
import org.koin.dsl.module


val repoModules: Module = module {
    single { LessonRepository(get()) }


}