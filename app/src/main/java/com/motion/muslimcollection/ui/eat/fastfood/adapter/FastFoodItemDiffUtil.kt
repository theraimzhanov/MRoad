package com.motion.muslimcollection.ui.eat.fastfood.adapter

import androidx.recyclerview.widget.DiffUtil
import com.motion.muslimcollection.model.cafe_model.FastFoodItem

class FastFoodItemDiffUtil: DiffUtil.ItemCallback<FastFoodItem>() {
    override fun areItemsTheSame(oldItem: FastFoodItem, newItem: FastFoodItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: FastFoodItem, newItem: FastFoodItem): Boolean {
          return oldItem == newItem
    }
}