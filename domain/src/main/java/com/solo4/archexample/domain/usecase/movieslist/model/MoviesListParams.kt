package com.solo4.archexample.domain.usecase.movieslist.model

data class MoviesListParams(
    val searchField: String,
    val type: MovieType? = null,
    val year: String? = null,
    val rating: String? = null //todo
)
