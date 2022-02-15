package com.motion.muslimcollection.model.cafe

data class CafeId(
    val address: String,
    val certificate: Boolean,
    val contacts: String,
    val id: Int,
    val images: String,
    val mosqueRoom: Boolean,
    val name: String
)