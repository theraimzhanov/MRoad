package com.motion.muslimcollection.model.address_model

data class CategoryItem(val name: String, val id: Int = UN_KNOW_ID) {
    companion object{
        const val UN_KNOW_ID = -1
    }
}