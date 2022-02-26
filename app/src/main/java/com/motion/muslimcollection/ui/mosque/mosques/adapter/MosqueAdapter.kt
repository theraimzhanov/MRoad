package com.motion.muslimcollection.ui.mosque.mosques.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.motion.muslimcollection.R
import com.motion.muslimcollection.ext.ItemClickListener
import com.motion.muslimcollection.model.address_model.MosqueItem

class MosqueAdapter:ListAdapter<MosqueItem,MosqueViewHolder>(MosqueItemDiffUtil()) {
    private var list: List<MosqueItem> = emptyList()
    fun getList(): List<MosqueItem>{
        return list
    }
    private lateinit var click: ItemClickListener

    fun setItemClickListener(clickListener: ItemClickListener){
        click = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MosqueViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_mosque,parent,false)
        return MosqueViewHolder(view,click)
    }

    override fun onBindViewHolder(holder: MosqueViewHolder, position: Int) {
        val mosqueItem = getItem(position)
        holder.mosquename.text = mosqueItem.name
    }
}