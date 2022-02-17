package com.motion.muslimcollection.model.lesson

import com.motion.muslimcollection.model.categless.Category
import java.util.*

data class LessonsItem(
    val name: String,
    val author: String,
    val audio: String,
    val category: Category,
    val id: Int
)