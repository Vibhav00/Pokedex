package com.example.mypokedex.pokemondetail

import androidx.lifecycle.ViewModel
import com.example.mypokedex.data.remote.responses.Pokemon
import com.example.mypokedex.repository.PokemonRepository
import com.example.mypokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}