package com.solo4.archexample.domain.repository

import com.solo4.archexample.domain.usecase.movieslist.model.Movie
import kotlinx.coroutines.flow.SharedFlow

interface MoviesRepository {
    val movies: SharedFlow<List<Movie>>
    suspend fun updateMoviesListByKeyword(keyword: String): Result<Unit>
    suspend fun getMovieById(id: Int): Result<Movie>
}
