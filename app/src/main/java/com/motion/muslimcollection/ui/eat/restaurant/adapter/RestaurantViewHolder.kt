package com.motion.muslimcollection.ui.eat.restaurant.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.R

class RestaurantViewHolder(val view: View):RecyclerView.ViewHolder(view) {
    val nameRestaurant: TextView = view.findViewById(R.id.res_name)
    val prayerRestaurant: TextView = view.findViewById(R.id.res_ms_room_yes)
    val phoneRestaurant: TextView = view.findViewById(R.id.res_phone)
    val locationRestaurant: TextView = view.findViewById(R.id.res_address)
    val imageViewRestaurant: ImageView = view.findViewById(R.id.img_restaurant)
}