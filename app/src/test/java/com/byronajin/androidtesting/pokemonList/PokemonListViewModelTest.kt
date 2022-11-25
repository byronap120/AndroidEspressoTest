package com.byronajin.androidtesting.pokemonList

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.byronajin.androidtesting.data.model.Pokemon
import com.byronajin.androidtesting.pokemonList.repository.PokemonListRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class PokemonListViewModelTest {

    // Rule to update LiveData values
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testGetPokemonList() = runTest {
        val testDispatcher = UnconfinedTestDispatcher(testScheduler)
        Dispatchers.setMain(testDispatcher)
        try {
            // Given
            val pokemonListFromServer = getPokemonFakeList()
            val mockPokemonListRepository = mockk<PokemonListRepository>()
            coEvery { mockPokemonListRepository.getPokemonList() } returns pokemonListFromServer

            val pokemonListViewModel = PokemonListViewModel(mockPokemonListRepository)

            // When
            pokemonListViewModel.loadPokemonList()

            // Then
            assertEquals(pokemonListViewModel.pokemonList.value, pokemonListFromServer)
        } finally {
            Dispatchers.resetMain()
        }
    }

    private fun getPokemonFakeList(): MutableList<Pokemon> {
        return mutableListOf(
            Pokemon("bulbasaur", "https://pokemon/", 1),
            Pokemon("ivysaur", "https://pokemon/", 2),
            Pokemon("venusaur", "https://pokemon/", 3),
        )
    }

}