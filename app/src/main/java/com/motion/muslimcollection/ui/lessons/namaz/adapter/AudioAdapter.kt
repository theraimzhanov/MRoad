package com.motion.muslimcollection.ui.lessons.namaz.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.motion.muslimcollection.R
import com.motion.muslimcollection.ext.ItemClickListener
import com.motion.muslimcollection.model.lesson_model.LessonItem

class AudioAdapter: ListAdapter<LessonItem, AudioViewHolder>(AudioItemDiffUtil()) {
    private var list: List<LessonItem> = emptyList()
    fun getList(): List<LessonItem> {
        return list
    }
    private lateinit var click: ItemClickListener
    fun setItemClickListener(clickListener: ItemClickListener) {
        click = clickListener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.audiolist,parent,false)
        return AudioViewHolder(view,click)

    }

    override fun onBindViewHolder(holder: AudioViewHolder, position: Int) {
        val lessonItem = getItem(position)
        holder.audioname.text = lessonItem.name

    }
}