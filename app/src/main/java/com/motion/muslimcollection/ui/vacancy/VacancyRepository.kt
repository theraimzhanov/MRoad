package com.motion.muslimcollection.ui.vacancy

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.motion.muslimcollection.data.remote.RemoteDataSource
import com.motion.muslimcollection.model.vacancies.VacancyItem
import com.motion.muslimcollection.network.result.Resource
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher
import retrofit2.Response

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
               emit(remoteDataSource.addVacancyList(vacancyItem))
           }
}