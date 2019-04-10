package com.bankin.callengeandroid.subcategory

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bankin.callengeandroid.R
import com.challenge.mob.core.model.SubCategoriesViewModel
import kotlinx.android.synthetic.main.cell_sub_category.view.*

class SubCategoryAdapter(
    val context: Context,
    private val subCategoriesViewModel: List<SubCategoriesViewModel>
) : RecyclerView.Adapter<SubCategoryAdapter.SubCategoriesViewHolder>() {

    class SubCategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val subCategoryTitleTextView: TextView = view.subCategoryTitleTextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.cell_sub_category,
            parent,
            false
        )
        return SubCategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubCategoriesViewHolder, position: Int) {
        holder.subCategoryTitleTextView.text = subCategoriesViewModel[position].name
    }

    override fun getItemCount(): Int = subCategoriesViewModel.size
}