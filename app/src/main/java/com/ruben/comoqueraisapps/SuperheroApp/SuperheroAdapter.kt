package com.ruben.comoqueraisapps.SuperheroApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ruben.comoqueraisapps.R

class SuperheroAdapter (var superheroList: List<SuperheroItemResponse> = emptyList(),
    val navigateToDetail: (String) -> Unit): RecyclerView.Adapter<SuperheroViewHolder>() {

    fun updateList(list: List<SuperheroItemResponse>) {
        superheroList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SuperheroViewHolder {
        return SuperheroViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_superhero, parent, false))
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        holder.bind(superheroList[position], navigateToDetail)
    }

    override fun getItemCount() = superheroList.size
}