package com.motion.muslimcollection.ui.lessons.namaz.adapter

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.R
import com.motion.muslimcollection.ext.ItemClickListener

class AudioViewHolder(val view: View, clickListener: ItemClickListener): RecyclerView.ViewHolder(view) {
    val audioname: TextView =view.findViewById(R.id.audioView)
    val button:Button = view.findViewById(R.id.button)

    init {
        itemView.setOnClickListener {
            clickListener.onItemClick(adapterPosition,)
        }
    }

}