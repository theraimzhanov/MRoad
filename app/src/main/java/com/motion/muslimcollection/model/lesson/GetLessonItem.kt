package com.motion.muslimcollection.model.lesson

data class GetLessonItem(
    val audio: String,
    val author: String,
    val category: String,
    val id: Int,
    val name: String
)