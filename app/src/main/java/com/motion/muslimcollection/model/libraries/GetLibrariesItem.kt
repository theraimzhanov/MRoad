package com.motion.muslimcollection.model.libraries

data class GetLibrariesItem(
    val address: String,
    val category: Int,
    val contacts: String,
    val id: Int,
    val images: String,
    val latitude: String,
    val longitude: String,
    val name: String,
    val work_time: String
)