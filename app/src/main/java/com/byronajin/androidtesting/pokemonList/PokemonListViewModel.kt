package com.byronajin.androidtesting.pokemonList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.byronajin.androidtesting.data.model.Pokemon
import com.byronajin.androidtesting.pokemonList.repository.PokemonListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val pokemonListRepository: PokemonListRepository
) : ViewModel() {

    private val _showLoader = MutableLiveData<Boolean>()
    val showLoader: LiveData<Boolean> = _showLoader

    private val _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList: LiveData<List<Pokemon>> = _pokemonList

    fun loadPokemonList() {
        _showLoader.value = true
        viewModelScope.launch {
            val result = pokemonListRepository.getPokemonList()
            result?.let {
                _pokemonList.value = it
                _showLoader.value = false
            }
        }
    }

}