package com.ruben.comoqueraisapps.BoardgamesApp

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CategoriesAdapter (private val categories: List<GameCategory>): RecyclerView.Adapter<CategoriesViewHolder> {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = categories.size
}