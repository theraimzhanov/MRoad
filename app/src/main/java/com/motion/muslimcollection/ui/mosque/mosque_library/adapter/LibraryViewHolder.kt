package com.motion.muslimcollection.ui.mosque.mosque_library.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.R

class LibraryViewHolder(val view: View):RecyclerView.ViewHolder(view) {
    val lb_name : TextView = view.findViewById(R.id.lb_name)
    val lb_address : TextView = view.findViewById(R.id.lb_address)
    val lb_phone : TextView = view.findViewById(R.id.lb_phone)
    val lb_img : ImageView = view.findViewById(R.id.img_library)

}