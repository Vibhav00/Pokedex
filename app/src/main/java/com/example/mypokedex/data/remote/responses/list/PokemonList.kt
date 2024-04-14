package com.example.mypokedex.data.remote.responses.list

data class PokemonList(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)