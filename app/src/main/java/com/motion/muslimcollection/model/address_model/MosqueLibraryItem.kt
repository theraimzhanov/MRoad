package com.motion.muslimcollection.model.address_model

data class MosqueLibraryItem(
    val name: String,
    val address: String,
    val contacts: String,
    val longitude: String,
    val latitude: String,
    val work_time: String,
    var id: Int = UN_KNOW_ID,
    var images: String? = null,
    var category:Int? = null
){
    companion object{
        const val UN_KNOW_ID = -1
    }
}