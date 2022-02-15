package com.motion.muslimcollection.model.rooms

data class GetRoomsItem(
    val address: String,
    val category: Int,
    val contacts: String,
    val gender: Int,
    val id: Int,
    val images: String,
    val latitude: String,
    val longitude: String,
    val name: String
)