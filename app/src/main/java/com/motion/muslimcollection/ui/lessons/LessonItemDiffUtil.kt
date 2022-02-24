package com.motion.muslimcollection.ui.lessons

import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.GenericTransitionOptions
import com.motion.muslimcollection.model.lesson_model.CategoryLesson

class LessonItemDiffUtil:DiffUtil.ItemCallback<CategoryLesson>() {
    override fun areItemsTheSame(
        oldItem: CategoryLesson,
        newItem: CategoryLesson
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: CategoryLesson,
        newItem: CategoryLesson
    ): Boolean {
        return oldItem == newItem

    }


}