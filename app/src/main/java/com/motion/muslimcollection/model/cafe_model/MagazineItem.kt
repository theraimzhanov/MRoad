package com.motion.muslimcollection.model.cafe_model

data class MagazineItem(
    val name: String,
    val contacts: String,
    val address: String,
    val site: String,
    var alcohol: Boolean = false,
    var certificate: Boolean = false,
    var images: String? = null,
    var mosqueRoom: Boolean = false,
    val longitude:String? = null,
    val latitude:String? = null,
    var productsCertificate: Boolean = false,
    var id: Int = UN_KNOW_ID
){
    companion object{
        const val UN_KNOW_ID = -1
    }
}