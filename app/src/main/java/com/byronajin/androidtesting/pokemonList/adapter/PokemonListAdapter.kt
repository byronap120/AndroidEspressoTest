package com.byronajin.androidtesting.pokemonList.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.byronajin.androidtesting.R
import com.byronajin.androidtesting.data.model.Pokemon

class PokemonListAdapter(private var dataSet: List<Pokemon>) :
    RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_pokemon_row, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

    fun updateList(list: List<Pokemon>) {
        dataSet = list
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val pokemonNameTextView: TextView
        private val pokemonNumberTextView: TextView

        init {
            pokemonNameTextView = view.findViewById(R.id.pokemonNameTextView)
            pokemonNumberTextView = view.findViewById(R.id.pokemonNumberTextView)
        }

        fun bind(pokemon: Pokemon) {
            pokemonNameTextView.text = pokemon.name
            pokemonNumberTextView.text = pokemon.number.toString()
        }
    }


}