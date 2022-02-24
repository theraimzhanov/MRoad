package com.motion.muslimcollection.ui.eat.restaurant.adapter

import androidx.recyclerview.widget.DiffUtil
import com.motion.muslimcollection.model.cafe_model.RestaurantItem

class RestaurantItemDiffUtil: DiffUtil.ItemCallback<RestaurantItem>() {

    override fun areItemsTheSame(oldItem: RestaurantItem, newItem: RestaurantItem): Boolean {
        return  oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RestaurantItem, newItem: RestaurantItem): Boolean {
        return oldItem == newItem
    }
}