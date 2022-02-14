package com.motion.muslimcollection.model

data class GetCafeItem(
    val address: String,
    val certificate: Boolean,
    val contacts: String,
    val id: Int,
    val images: String,
    val mosqueRoom: Boolean,
    val name: String
)