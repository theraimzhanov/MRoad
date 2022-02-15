package com.motion.muslimcollection.ui.lessons

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.R
import com.motion.muslimcollection.ext.ItemClickListener
import com.motion.muslimcollection.model.lesson.LessonsCategoriesItem

class AdapterLessonCategories():RecyclerView.Adapter<AdapterLessonCategories.LessonViewHolder>() {
    private var list: List<LessonsCategoriesItem> = emptyList()
    fun setList(list: List<LessonsCategoriesItem>) {
        this.list = list
        notifyDataSetChanged()
    }
    fun getList(): List<LessonsCategoriesItem> {
        return list
    }
    private lateinit var click: ItemClickListener
    fun setItemClickListener(clickListener: ItemClickListener) {
        click = clickListener
    }
    class LessonViewHolder(itemView:View,clickListener: ItemClickListener):RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.text_categories)
        init {
            itemView.setOnClickListener {

                clickListener.onItemClick(adapterPosition,)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.listlessoncategories, parent, false)
        return LessonViewHolder(itemView, click)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        val code = list[position]
        holder.name.text = code.name
        Log.d("TAG", "onBindViewHolder:"+code.name)
    }

    override fun getItemCount() = list.size


}