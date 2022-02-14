package com.motion.muslimcollection.model.mosque_colleges

data class GetCollegesItem(
    val address: String,
    val category: Int,
    val contacts: String,
    val id: Int,
    val images: String,
    val latitude: String,
    val longitude: String,
    val name: String
)