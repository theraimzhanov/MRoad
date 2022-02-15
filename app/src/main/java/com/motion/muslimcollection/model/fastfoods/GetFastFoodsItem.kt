package com.motion.muslimcollection.model.fastfoods

data class GetFastFoodsItem(
    val address: String,
    val certificate: Boolean,
    val contacts: String,
    val id: Int,
    val images: String,
    val mosqueRoom: Boolean,
    val name: String,
    val site: String,
    val workTime: String
)