package com.motion.muslimcollection.ui.mosque.mosque_madrasah.adapter

import androidx.recyclerview.widget.DiffUtil
import com.motion.muslimcollection.model.address_model.MadrasahItem

class MadrasahItemDiffUtil:DiffUtil.ItemCallback<MadrasahItem>() {

    override fun areItemsTheSame(oldItem: MadrasahItem, newItem: MadrasahItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MadrasahItem, newItem: MadrasahItem): Boolean {
        return oldItem == newItem
    }
}