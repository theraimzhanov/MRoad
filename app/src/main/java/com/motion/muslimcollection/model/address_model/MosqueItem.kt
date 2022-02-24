package com.motion.muslimcollection.model.address_model

data class MosqueItem(
    val name: String,
    val address: String,
    val contacts: String,
    val latitude: String,
    val longitude: String,
    var category: Int? = null,
    var id: Int = UN_KNOW_ID,
    var images: String? = null,
){
    companion object{
        const val UN_KNOW_ID = -1
    }
}