package com.solo4.archexample.domain.repository

import com.solo4.archexample.domain.usecase.movieslist.model.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun updateMoviesListByKeyword(keyword: String): Flow<List<Movie>>
    suspend fun getMovieById(id: Int): Movie
}
