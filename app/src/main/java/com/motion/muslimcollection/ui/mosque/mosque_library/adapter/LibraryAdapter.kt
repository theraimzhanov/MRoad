package com.motion.muslimcollection.ui.mosque.mosque_library.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.motion.muslimcollection.R
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.model.address_model.MosqueLibraryItem
import com.motion.muslimcollection.ui.mosque.mosques.adapter.MosqueViewHolder
import com.squareup.picasso.Picasso

class LibraryAdapter:androidx.recyclerview.widget.ListAdapter<MosqueLibraryItem,LibraryViewHolder>(LibraryItemDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_library,parent,false)
        return LibraryViewHolder(view)
    }

    override fun onBindViewHolder(holder: LibraryViewHolder, position: Int) {
        val libraryItem = getItem(position)
        holder.lb_name.text = libraryItem.name
        holder.lb_address.text = libraryItem.address
        holder.lb_phone.text = libraryItem.contacts

        Picasso.get()
            .load(libraryItem.images)
            .placeholder(R.drawable.ic)
            .error(R.drawable.ic_baseline_image_not)
            .into(holder.lb_img)

    }

}