package com.PokeCompa.pokemonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.PokeCompa.pokemonapp.network.PokemonLoad
import com.PokeCompa.pokemonapp.network.models.PokemonRespuesta
import com.PokeCompa.pokemonapp.ui.theme.PokemonAppTheme
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback
import android.util.Log
import com.PokeCompa.pokemonapp.utils.Constant
import retrofit2.http.Tag

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokemonAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        val constant = Constant()
        var load = PokemonLoad()
        var call: Call<PokemonRespuesta> = load.obtenerListaPokemon()

        call.enqueue(object : Callback<PokemonRespuesta> {
            override fun onResponse(call: Call<PokemonRespuesta>, response: Response<PokemonRespuesta>) {
                Log.e(constant.DEBUG, "" )
            }

            override fun onFailure(call: Call<PokemonRespuesta>, t: Throwable) {
                val errorMessage = t.message
                print("Error: $errorMessage")
            }
        })
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokemonAppTheme {
        Greeting("Android")
    }
}