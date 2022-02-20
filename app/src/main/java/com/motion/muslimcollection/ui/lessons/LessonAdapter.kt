package com.motion.muslimcollection.ui.lessons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.motion.muslimcollection.R
import com.motion.muslimcollection.ext.ItemClickListener
import com.motion.muslimcollection.model.lessoncategories.GetLessonCategoriesItem

class LessonAdapter:ListAdapter<GetLessonCategoriesItem,LessonViewHolder>(LessonItemDiffUtil()) {
    private var list: List<GetLessonCategoriesItem> = emptyList()
    fun getList(): List<GetLessonCategoriesItem> {
        return list
    }
    private lateinit var click: ItemClickListener

    fun setItemClickListener(clickListener: ItemClickListener) {
        click = clickListener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listlessoncategories,parent,false)
        return LessonViewHolder(view,click)
    }
    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        val lessonItem = getItem(position)
        holder.lessonname.text = lessonItem.name
    }
}