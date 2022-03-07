package com.motion.muslimcollection.ui.eat.magazine.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.R

class MagazineViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val nameOfMagazine:TextView = view.findViewById(R.id.nameOfMagazine)
    val timeOfMagazine:TextView = view.findViewById(R.id.timeOfMagazine)
    val phoneOfMagazine:TextView = view.findViewById(R.id.phoneOfMagazine)
    val locationMagazine:TextView = view.findViewById(R.id.locationMagazine)
    val imageViewOfMagazine:ImageView = view.findViewById(R.id.imageViewMagazine)
}