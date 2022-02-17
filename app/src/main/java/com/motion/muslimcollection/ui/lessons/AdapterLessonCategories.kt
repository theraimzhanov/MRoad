package com.motion.muslimcollection.ui.lessons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.R
import com.motion.muslimcollection.ext.ItemClickListener
import com.motion.muslimcollection.model.lessoncategories.GetLessonCategoriesItem


class AdapterLessonCategories(var list: List<GetLessonCategoriesItem>) : RecyclerView.Adapter<AdapterLessonCategories.LessonViewHolder>() {

    @JvmName("setList1")
    fun setList(list: List<GetLessonCategoriesItem>) {
        this.list = list
        notifyDataSetChanged()
    }

    class LessonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.tv_less_namaz)
        val lesson = itemView.findViewById<TextView>(R.id.tv_lesss_body)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.listlessoncategories, parent, false)
        return LessonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        val lesson = list[position]
        holder.name.text = lesson.name
        holder.lesson.text = lesson.lessons
    }
    override fun getItemCount(): Int {
        return list.size
    }
}
