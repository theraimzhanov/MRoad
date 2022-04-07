package com.motion.muslimcollection.model.cafe_model

data class FastFoodItem(
    val name: String,
    val contacts: String,
    val address: String,
    val workTime: String,
    val site: String,
    var certificate: Boolean = false,
    var mosqueRoom: Boolean = false,
    var images: String? = null,
    val longitude:String,
    val latitude:String,
    var id: Int = UN_KNOW_ID
){
    companion object{
        const val UN_KNOW_ID = -1
    }
}