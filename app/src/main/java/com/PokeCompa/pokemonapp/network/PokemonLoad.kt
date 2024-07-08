package com.PokeCompa.pokemonapp.network

import com.PokeCompa.pokemonapp.network.models.PokemonRespuesta
import retrofit2.Call
import retrofit2.Retrofit

class PokemonLoad : PokeAPI {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val pokemonApi: PokeAPI = retrofit.create(PokeAPI::class.java)
    override fun obtenerListaPokemon(): Call<PokemonRespuesta> {
        TODO("Not yet implemented")
    }
}