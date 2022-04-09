package com.motion.muslimcollection.model.cafe_model

data class MagazineItem(
    val name: String,
    val contacts: String,
    val address: String,
    val site: String = EMPTY_PAGE,
    var alcohol: Boolean = false,
    var certificate: Boolean = false,
    var images: String? = null,
    var worktime:String = WORK_PAGE,
    var mosqueRoom: Boolean = false,
    val longitude:String? = null,
    val latitude:String? = null,
    var productsCertificate: Boolean = false,
    var id: Int = UN_KNOW_ID
){
    companion object{
        const val UN_KNOW_ID = -1
        const val EMPTY_PAGE = "Atabek"
        const val WORK_PAGE = "8:00"
    }
}