package com.motion.muslimcollection.model.time_model

data class LocationItem(
    val location: String,
    var id:Int = UN_KNOW_ID
){
    companion object{
    const val UN_KNOW_ID = -1
}}