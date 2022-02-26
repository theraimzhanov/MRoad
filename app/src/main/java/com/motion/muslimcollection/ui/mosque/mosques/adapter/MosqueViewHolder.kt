package com.motion.muslimcollection.ui.mosque.mosques.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.R
import com.motion.muslimcollection.ext.ItemClickListener

class MosqueViewHolder(val view: View,clickListener: ItemClickListener): RecyclerView.ViewHolder(view){
    val mosquename : TextView = view.findViewById(R.id.mosque_text_list)
    init {
        itemView.setOnClickListener {
            clickListener.onItemClick(adapterPosition,)
        }
    }
}