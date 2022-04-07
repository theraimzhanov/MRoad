package com.motion.muslimcollection.model.cafe_model

data class RestaurantItem(
    val name: String,
    val contacts: String,
    val address: String,
    var certificate: Boolean = false,
    var mosqueRoom: Boolean = false,
    var bigHall: Int = SIZE_BIG_HALL,
    val longitude:String? = null,
    val latitude:String? = null,
    var images:String? = null,
    var  id:Int = UN_KNOW_ID
){
    companion object{
        const val UN_KNOW_ID = -1
        const val SIZE_BIG_HALL = 0
    }
}