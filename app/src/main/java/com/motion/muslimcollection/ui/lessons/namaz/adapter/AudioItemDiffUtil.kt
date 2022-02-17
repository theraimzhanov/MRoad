package com.motion.muslimcollection.ui.lessons.namaz.adapter

import androidx.recyclerview.widget.DiffUtil
import com.motion.muslimcollection.model.lesson.LessonsItem
import com.motion.muslimcollection.model.lessoncategories.GetLessonCategoriesItem

class AudioItemDiffUtil: DiffUtil.ItemCallback<LessonsItem>() {
    override fun areItemsTheSame(oldItem: LessonsItem, newItem: LessonsItem): Boolean {
        return  return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: LessonsItem, newItem: LessonsItem): Boolean {
        return oldItem == newItem
    }
}