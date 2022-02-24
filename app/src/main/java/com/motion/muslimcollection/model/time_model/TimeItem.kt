package com.motion.muslimcollection.model.time_model

data class TimeItem(
    val fifth_time: String,
    val first_time: String,
    val fourth_time: String,
    val second_time: String,
    val sixth_time: String,
    val third_time: String,
    var id: Int = UN_KNOW_ID,
    var locationItem: LocationItem? =null ,
    var date:String? = null
){
        companion object{
            const val UN_KNOW_ID = -1
    }
}