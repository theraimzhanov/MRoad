package com.motion.muslimcollection.ui.mosque.mosque_college.adapter

import androidx.recyclerview.widget.DiffUtil
import com.motion.muslimcollection.model.address_model.MosqueCollegeItem

class CollegeItemDiffUtil:DiffUtil.ItemCallback<MosqueCollegeItem>() {

    override fun areItemsTheSame(oldItem: MosqueCollegeItem, newItem: MosqueCollegeItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: MosqueCollegeItem,
        newItem: MosqueCollegeItem
    ): Boolean {
        return oldItem == newItem
    }
}