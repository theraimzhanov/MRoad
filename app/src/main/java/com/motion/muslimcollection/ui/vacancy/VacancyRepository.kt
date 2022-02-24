package com.motion.muslimcollection.ui.vacancy

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.motion.muslimcollection.data.remote.RemoteDataSource
import com.motion.muslimcollection.model.vacancy_model.VacancyItem
import com.motion.muslimcollection.network.result.Resource
import kotlinx.coroutines.Dispatchers

class VacancyRepository(private val remoteDataSource: RemoteDataSource) {

           fun getVacancyList():LiveData<Resource<List<VacancyItem>>> = liveData(Dispatchers.IO) {
               emit(Resource.loading(null))
               emit(remoteDataSource.getVacancyList())
           }

    fun getVacancyItem(id:Int):LiveData<Resource<VacancyItem>> = liveData (Dispatchers.IO) {
        emit(Resource.loading(null))
        val result = remoteDataSource.getVacancyItem(id)
        emit(result)
    }
           fun addVacancyItem(vacancyItem: VacancyItem):LiveData<Resource<VacancyItem>> = liveData(Dispatchers.IO) {
               emit(Resource.loading(null))
               emit(remoteDataSource.postVacancyList(vacancyItem))
           }
}