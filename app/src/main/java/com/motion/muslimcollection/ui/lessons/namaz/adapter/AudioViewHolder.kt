package com.motion.muslimcollection.ui.lessons.namaz.adapter

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.R
import com.motion.muslimcollection.ext.ItemClickListener

class AudioViewHolder(val view: View, clickListener: ItemClickListener): RecyclerView.ViewHolder(view) {
    val name: TextView =view.findViewById(R.id.tv_audio_name)
    val name_author: TextView =view.findViewById(R.id.tv_author_name)
    init {
        itemView.setOnClickListener {
            clickListener.onItemClick(adapterPosition,)
        }
    }

}