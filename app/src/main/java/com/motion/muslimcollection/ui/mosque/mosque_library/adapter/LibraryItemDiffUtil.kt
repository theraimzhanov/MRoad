package com.motion.muslimcollection.ui.mosque.mosque_library.adapter

import androidx.recyclerview.widget.DiffUtil
import com.motion.muslimcollection.model.address_model.MosqueLibraryItem

class LibraryItemDiffUtil: DiffUtil.ItemCallback<MosqueLibraryItem>() {

    override fun areItemsTheSame(oldItem: MosqueLibraryItem, newItem: MosqueLibraryItem): Boolean {
       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MosqueLibraryItem, newItem: MosqueLibraryItem): Boolean {
        return oldItem == newItem
    }
}