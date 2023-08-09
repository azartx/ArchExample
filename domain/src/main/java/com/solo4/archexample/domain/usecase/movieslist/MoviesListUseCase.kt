package com.solo4.archexample.domain.usecase.movieslist

import com.solo4.archexample.domain.usecase.movieslist.model.Movie
import com.solo4.archexample.domain.usecase.movieslist.model.MoviesListParams
import kotlinx.coroutines.flow.Flow

interface MoviesListUseCase {
    fun execute(params: MoviesListParams): Flow<List<Movie>>
}
