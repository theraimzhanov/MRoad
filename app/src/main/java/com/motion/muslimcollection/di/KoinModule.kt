package com.motion.muslimcollection.di

import com.motion.muslimcollection.data.remote.remoteDataSourceModule
import com.motion.muslimcollection.network.networkModule

val koinModules= listOf(
    networkModule,
    remoteDataSourceModule,
    viewModules,
    repoModules,
)