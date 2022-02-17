package com.motion.muslimcollection.model.lessoncategories

data class GetLessonCategoriesItem(
    val id: Int ,
    val lessons: String,
    val name: String
){
    companion object{
        const val START_ID = -1
        const val START_LESSON = "LESSON"
    }
}


