package com.motion.muslimcollection.ui.lessons.namaz.adapter

import androidx.recyclerview.widget.DiffUtil
import com.motion.muslimcollection.model.lesson_model.LessonItem

class AudioItemDiffUtil: DiffUtil.ItemCallback<LessonItem>() {
    override fun areItemsTheSame(oldItem: LessonItem, newItem: LessonItem): Boolean {
        return  return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: LessonItem, newItem: LessonItem): Boolean {
        return oldItem == newItem
    }
}