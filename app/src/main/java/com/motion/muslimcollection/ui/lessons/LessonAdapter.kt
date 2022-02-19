package com.motion.muslimcollection.ui.lessons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.motion.muslimcollection.R
import com.motion.muslimcollection.model.lessoncategories.GetLessonCategoriesItem
import com.motion.muslimcollection.ui.vacancy.adapter.VacancyViewHolder

class LessonAdapter:ListAdapter<GetLessonCategoriesItem,LessonViewHolder>(LessonItemDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listlessoncategories,parent,false)
        return LessonViewHolder(view)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        val lessonItem = getItem(position)
        holder.lessonname.text = lessonItem.name
    }
}