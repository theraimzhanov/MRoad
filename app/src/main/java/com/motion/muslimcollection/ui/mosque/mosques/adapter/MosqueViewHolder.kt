package com.motion.muslimcollection.ui.mosque.mosques.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.R
import com.motion.muslimcollection.ext.ItemClickListener

class MosqueViewHolder(val view: View): RecyclerView.ViewHolder(view){
    val ms_name : TextView = view.findViewById(R.id.ms_name)
    val ms_address : TextView = view.findViewById(R.id.ms_address)
    val ms_phone : TextView = view.findViewById(R.id.ms_phone)
    val s : ImageView = view.findViewById(R.id.img_mosques)


}