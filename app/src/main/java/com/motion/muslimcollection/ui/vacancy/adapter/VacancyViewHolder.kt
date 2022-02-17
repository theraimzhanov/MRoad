package com.motion.muslimcollection.ui.vacancy.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.motion.muslimcollection.R

class VacancyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val textViewNameOfVacancy: TextView =view.findViewById(R.id.nameOfVacancy)
    val textViewSalaryOfVacancy: TextView =view.findViewById(R.id.salaryOfVacancy)
}