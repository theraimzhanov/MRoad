package com.motion.muslimcollection.ui.mosque.mosque_college.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.R

class CollegeViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val cl_name : TextView = view.findViewById(R.id.cl_name)
    val cl_address : TextView = view.findViewById(R.id.cl_address)
    val cl_phone : TextView = view.findViewById(R.id.cl_phone)
    val cl_img : ImageView = view.findViewById(R.id.img_college)
}
