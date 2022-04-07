package com.motion.muslimcollection.model.address_model

class UniversityItem(
    val address: String,
    val latitude: String,
    val longitude: String,
    val contacts: String,
    var name: String? = null,
    var id: Int = UN_KNOW_ID,
    var images: String? = null,
    var category: Int? = null
) {
    companion object {
        const val UN_KNOW_ID = -1
    }
}
