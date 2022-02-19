package com.motion.muslimcollection.ui.lessons

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.R

class LessonViewHolder(val view: View):RecyclerView.ViewHolder(view) {
    val lessonname: TextView =view.findViewById(R.id.tv_less_namaz)
}