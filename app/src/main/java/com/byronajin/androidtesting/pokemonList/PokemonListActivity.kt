package com.byronajin.androidtesting.pokemonList

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.byronajin.androidtesting.databinding.ActivityPokemonListBinding
import com.byronajin.androidtesting.pokemonList.adapter.PokemonListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonListBinding
    private lateinit var adapter: PokemonListAdapter
    val viewModel: PokemonListViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.hide()

        initObservers()
        initPokemonList()
        viewModel.loadPokemonList()
    }

    private fun initObservers() {
        viewModel.showLoader.observe(this) {
            binding.pokemonLoader.visibility = if (it) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }

        viewModel.pokemonList.observe(this) {
            adapter.updateList(it)
            binding.pokemonRecyclerView.visibility = View.VISIBLE
        }

    }

    private fun initPokemonList() {
        binding.pokemonRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PokemonListAdapter(listOf())
        binding.pokemonRecyclerView.adapter = adapter
    }
}