package com.motion.muslimcollection.data.remote

import com.motion.muslimcollection.network.BaseDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    factory { RemoteDataSource(get()) }
}

class RemoteDataSource(private val apiService: Service) : BaseDataSource() {

}