package com.motion.muslimcollection.model.lesson

class LessonsItem(val  name:String,var lesson:String = START_LESSON)
{


companion object{
    const val START_ID = -1
    const val START_LESSON = "LESSON"
}
}