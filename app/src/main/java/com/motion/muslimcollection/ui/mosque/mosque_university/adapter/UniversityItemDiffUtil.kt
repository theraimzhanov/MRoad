package com.motion.muslimcollection.ui.mosque.mosque_university.adapter

import androidx.recyclerview.widget.DiffUtil
import com.motion.muslimcollection.model.address_model.UniversityItem

class UniversityItemDiffUtil : DiffUtil.ItemCallback<UniversityItem>() {
    override fun areItemsTheSame(oldItem: UniversityItem, newItem: UniversityItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UniversityItem, newItem: UniversityItem): Boolean {
        return oldItem == newItem
    }
}
