package com.motion.muslimcollection.ui.eat.magazine.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.R

class MagazineViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val nameOfMagazine:TextView = view.findViewById(R.id.mg_name)
    val timeOfMagazine:TextView = view.findViewById(R.id.mg_work_time)
    val phoneOfMagazine:TextView = view.findViewById(R.id.mg_phone)
    val locationMagazine:TextView = view.findViewById(R.id.mg_address)
    val imageViewOfMagazine:ImageView = view.findViewById(R.id.img_magazine)
}