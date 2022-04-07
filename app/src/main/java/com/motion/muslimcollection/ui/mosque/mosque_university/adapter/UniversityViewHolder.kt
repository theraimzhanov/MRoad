package com.motion.muslimcollection.ui.mosque.mosque_university.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.R

class UniversityViewHolder (val view: View): RecyclerView.ViewHolder(view){
    val un_name : TextView = view.findViewById(R.id.un_name)
    val un_address : TextView = view.findViewById(R.id.un_address)
    val un_phone : TextView = view.findViewById(R.id.un_phone)
    val un_img : ImageView = view.findViewById(R.id.img_university)

}