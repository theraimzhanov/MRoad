package com.motion.muslimcollection.ui.eat.restaurant.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.motion.muslimcollection.model.cafe_model.RestaurantItem

class RestaurantAdapter:ListAdapter<RestaurantItem,RestaurantViewHolder>(RestaurantItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}