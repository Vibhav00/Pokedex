package com.example.mypokedex.repository

import com.example.mypokedex.data.remote.PokeApi
import com.example.mypokedex.data.remote.responses.Pokemon
import com.example.mypokedex.data.remote.responses.list.PokemonList
import com.example.mypokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

//package com.example.mypokedex.repository

@ActivityScoped
class PokemonRepository @Inject constructor(
   private val api: PokeApi
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch(e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch(e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }
}