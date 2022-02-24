package com.motion.muslimcollection.model.address_model

data class MosqueCollegeItem(
    val name: String,
    val address: String,
    val contacts: String,
    val longitude: String,
    val latitude: String,
    var images:String? = null,
    var category: Int? = null,
    var id: Int = UN_KNOW_ID,
){
    companion object{
        const val UN_KNOW_ID = -1
    }
}