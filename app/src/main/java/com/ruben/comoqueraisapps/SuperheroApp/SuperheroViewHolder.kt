package com.ruben.comoqueraisapps.SuperheroApp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import com.ruben.comoqueraisapps.databinding.ItemGameBinding
import com.ruben.comoqueraisapps.databinding.ItemSuperheroBinding

class SuperheroViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)
    fun bind(superhero: SuperheroItemResponse, navigateToDetail: (String) -> Unit) {
        binding.tvSuperheroName.text = superhero.name
        binding.ivSuperhero.load(superhero.superheroImage.url)
        binding.root.setOnClickListener { navigateToDetail(superhero.superheroId) }
    }
}