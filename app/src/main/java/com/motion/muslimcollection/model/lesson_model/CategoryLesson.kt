package com.motion.muslimcollection.model.lesson_model

data class CategoryLesson(
    val name: String,
    var id: Int = UN_KNOW_ID,
    var lessons: List<LessonItem>? = null,
) {
    companion object {
        const val UN_KNOW_ID = -1
    }
}