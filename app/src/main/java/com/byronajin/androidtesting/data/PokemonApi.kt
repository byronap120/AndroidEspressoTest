package com.byronajin.androidtesting.data

import com.byronajin.androidtesting.data.model.PokemonResponse
import retrofit2.http.GET

interface PokemonApi {

    @GET("/api/v2//pokemon")
    suspend fun getPokemonList(): PokemonResponse
}