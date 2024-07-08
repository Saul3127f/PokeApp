package com.PokeCompa.pokemonapp.network

import com.PokeCompa.pokemonapp.network.models.PokemonRespuesta
import retrofit2.http.GET
import retrofit2.Call

interface PokeAPI {
    @GET("pokemon")
    fun obtenerListaPokemon() : Call<PokemonRespuesta>
}