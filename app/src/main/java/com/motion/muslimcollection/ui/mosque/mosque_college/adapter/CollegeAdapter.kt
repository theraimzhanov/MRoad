package com.motion.muslimcollection.ui.mosque.mosque_college.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.motion.muslimcollection.R
import com.motion.muslimcollection.model.address_model.MosqueCollegeItem
import com.motion.muslimcollection.ui.mosque.mosque_madrasah.adapter.MadrasahViewHolder
import com.squareup.picasso.Picasso

class CollegeAdapter:ListAdapter<MosqueCollegeItem,CollegeViewHolder>
    (CollegeItemDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollegeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_college,parent,false)
        return CollegeViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollegeViewHolder, position: Int) {
        val collegeItem = getItem(position)
        holder.cl_name.text = collegeItem.name
        holder.cl_address.text = collegeItem.address
        holder.cl_phone.text = collegeItem.contacts
        Picasso.get()
            .load(collegeItem.images)
            .placeholder(R.drawable.ic)
            .error(R.drawable.ic_baseline_image_not)
            .into(holder.cl_img);


    }
}