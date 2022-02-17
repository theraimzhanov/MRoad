package com.motion.muslimcollection.di


import com.motion.muslimcollection.ui.vacancy.VacancyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModules: Module = module {
viewModel {VacancyViewModel(get()) }
}