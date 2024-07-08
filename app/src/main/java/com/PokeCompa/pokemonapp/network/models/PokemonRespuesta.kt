package com.PokeCompa.pokemonapp.network.models

import com.google.gson.annotations.SerializedName

class PokemonRespuesta {
    private var count : Int = 0
    private lateinit var next: String
    private lateinit var previus: String
    @SerializedName("results")
    private lateinit var pokemonList: MutableList<Pokemon>


    class Pokemon{
        private lateinit var name:String
        private lateinit var url: String
    }
}