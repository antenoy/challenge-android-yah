package com.bankin.callengeandroid.category

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bankin.callengeandroid.R
import com.challenge.mob.core.model.CategoriesViewModel
import kotlinx.android.synthetic.main.cell_main_category.view.*

class CategoriesAdapter(
    val context: Context,
    private val categories: List<CategoriesViewModel>,
    private val onCategoryClickListener: (String, String) -> Unit
) : RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    class CategoriesViewHolder(view: View) : ViewHolder(view) {
        val categoryTitle: TextView = view.categoryTitle
        val categoryCardView: CardView = view.categoryCardView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.cell_main_category,
            parent,
            false
        )
        return CategoriesViewHolder(view)
    }


    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.categoryTitle.text = categories[position].name
        holder.categoryCardView.setOnClickListener {
            onCategoryClickListener(categories[position].id, categories[position].name)
        }
    }

    override fun getItemCount(): Int = categories.size

}