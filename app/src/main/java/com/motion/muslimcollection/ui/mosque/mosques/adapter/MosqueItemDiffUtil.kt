package com.motion.muslimcollection.ui.mosque.mosques.adapter

import androidx.recyclerview.widget.DiffUtil
import com.motion.muslimcollection.model.address_model.MosqueItem

class MosqueItemDiffUtil:DiffUtil.ItemCallback<MosqueItem>() {

    override fun areItemsTheSame(oldItem: MosqueItem, newItem: MosqueItem): Boolean {
       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MosqueItem, newItem: MosqueItem): Boolean {
        return oldItem == newItem
    }
}