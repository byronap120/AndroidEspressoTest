package com.byronajin.androidtesting.pokemonList.repository

import com.byronajin.androidtesting.data.PokemonApi
import com.byronajin.androidtesting.data.model.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonListRepository @Inject constructor(private val pokemonApi: PokemonApi) {

    suspend fun getPokemonList(): MutableList<Pokemon>? {
        return withContext(Dispatchers.IO) {
            try {
                val result = pokemonApi.getPokemonList()
                updatePokemonNumber(result.results)
                return@withContext result.results
            } catch (e: Exception) {
                return@withContext null
            }
        }
    }

    private fun updatePokemonNumber(pokemonList: MutableList<Pokemon>) {
        pokemonList.forEachIndexed { index, pokemon ->
            pokemon.number = index + 1
        }
    }

}