package com.motion.muslimcollection.ui.lessons

import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.GenericTransitionOptions
import com.motion.muslimcollection.model.lessoncategories.GetLessonCategoriesItem

class LessonItemDiffUtil:DiffUtil.ItemCallback<GetLessonCategoriesItem>() {
    override fun areItemsTheSame(
        oldItem: GetLessonCategoriesItem,
        newItem: GetLessonCategoriesItem
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: GetLessonCategoriesItem,
        newItem: GetLessonCategoriesItem
    ): Boolean {
        return oldItem == newItem

    }


}