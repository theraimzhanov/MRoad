package com.motion.muslimcollection.model.magazines

data class GetMagaziesItem(
    val address: String,
    val alcohol: Boolean,
    val certificate: Boolean,
    val contacts: String,
    val id: Int,
    val images: String,
    val mosqueRoom: Boolean,
    val name: String,
    val productsCertificate: Boolean,
    val site: String
)