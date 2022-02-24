package com.motion.muslimcollection.ui.eat.fastfood.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.model.cafe_model.FastFoodItem

class FastFoodAdapter: androidx.recyclerview.widget.ListAdapter<FastFoodItem,FastFoodViewHolder>(FastFoodItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FastFoodViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: FastFoodViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}