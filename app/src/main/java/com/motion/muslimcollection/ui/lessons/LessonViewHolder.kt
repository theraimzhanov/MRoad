package com.motion.muslimcollection.ui.lessons

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.R
import com.motion.muslimcollection.ext.ItemClickListener

class LessonViewHolder(val view: View,clickListener: ItemClickListener):RecyclerView.ViewHolder(view) {
    val lessonname: TextView =view.findViewById(R.id.tv_less_namaz)
    init {
        itemView.setOnClickListener {
            clickListener.onItemClick(adapterPosition,)
        }
    }
}