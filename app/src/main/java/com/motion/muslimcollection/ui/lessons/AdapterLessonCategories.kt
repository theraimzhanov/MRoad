package com.motion.muslimcollection.ui.lessons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.maps.GoogleMap
import com.motion.muslimcollection.R
import com.motion.muslimcollection.ext.ItemClickListener
import com.motion.muslimcollection.model.lessoncategories.GetLessonCategoriesItem

class AdapterLessonCategories():RecyclerView.Adapter<AdapterLessonCategories.LessonViewHolder>() {
    private var list: List<GetLessonCategoriesItem> = emptyList()
    fun setList(list: List<GetLessonCategoriesItem>) {
        this.list = list
        notifyDataSetChanged()
    }
    private lateinit var click: ItemClickListener
    fun getList(): List<GetLessonCategoriesItem> {
        return list
    }
    fun setItemClickListener(clickListener: ItemClickListener) {
        click = clickListener
    }

    class LessonViewHolder(itemView: View,clickListener: ItemClickListener):RecyclerView.ViewHolder(itemView) {
        val categories = itemView.findViewById<TextView>(R.id.text_categories)
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
        val code= list[position]
        holder.categories.text =code.name
    }
    override fun getItemCount() = list.size

}