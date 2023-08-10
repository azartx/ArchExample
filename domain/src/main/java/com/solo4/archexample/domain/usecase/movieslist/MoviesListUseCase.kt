package com.solo4.archexample.domain.usecase.movieslist

import com.solo4.archexample.domain.usecase.movieslist.model.Movie
import com.solo4.archexample.domain.usecase.movieslist.model.MoviesListParams
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow

interface MoviesListUseCase {

    val moviesFlow: SharedFlow<List<Movie>>
    suspend fun execute(params: MoviesListParams): Result<Unit>
}
