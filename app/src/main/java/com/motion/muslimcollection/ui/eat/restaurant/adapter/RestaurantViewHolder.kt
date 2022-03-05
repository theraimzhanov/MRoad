package com.motion.muslimcollection.ui.eat.restaurant.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.R

class RestaurantViewHolder(val view: View):RecyclerView.ViewHolder(view) {
    val nameRestaurant: TextView = view.findViewById(R.id.nameOfCafe)
    val prayerRestaurant: TextView = view.findViewById(R.id.prayerCafe)
    val phoneRestaurant: TextView = view.findViewById(R.id.phoneOfCafe)
    val locationRestaurant: TextView = view.findViewById(R.id.locationCafe)
    val imageViewRestaurant: ImageView = view.findViewById(R.id.imageViewCafe)
}