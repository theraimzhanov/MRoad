package com.motion.muslimcollection.model.cafe_model

data class CafeItem(
    val name: String,
    val address: String,
    val contacts: String,
    var certificate: Boolean = false,
    var mosqueRoom: Boolean = false,
    var images: String? = null,
    var id: Int = UN_KNOW_ID,
){
    companion object{
        const val UN_KNOW_ID = -1
    }
}
