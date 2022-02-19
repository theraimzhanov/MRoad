package com.motion.muslimcollection.model.lessoncategories

import com.motion.muslimcollection.model.lesson.LessonsItem

data class GetLessonCategoriesItem(
    val id: Int ,
    val lessons:List<LessonsItem>? = null,
    val name: String
){
    companion object{
        const val START_ID = -1
        const val START_LESSON = "LESSON"
    }
}


