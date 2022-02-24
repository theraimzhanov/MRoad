package com.motion.muslimcollection.model.lesson_model



data class LessonItem(
    val name: String,
    val author: String,
    var audio: String? = null,
    var category: CategoryLesson? = null,
    var id: Int = UN_KNOW_ID
){
    companion object{
        const val UN_KNOW_ID = -1
    }
}