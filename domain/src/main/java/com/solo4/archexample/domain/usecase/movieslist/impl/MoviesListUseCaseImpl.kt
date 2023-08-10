package com.solo4.archexample.domain.usecase.movieslist.impl

import com.solo4.archexample.domain.usecase.movieslist.model.Movie
import com.solo4.archexample.domain.usecase.movieslist.model.MoviesListParams
import com.solo4.archexample.domain.repository.MoviesRepository
import com.solo4.archexample.domain.usecase.movieslist.MoviesListUseCase
import kotlinx.coroutines.flow.SharedFlow

class MoviesListUseCaseImpl(private val moviesRepository: MoviesRepository) : MoviesListUseCase {

    override val moviesFlow: SharedFlow<List<Movie>> = moviesRepository.movies
    override suspend fun execute(params: MoviesListParams): Result<Unit> {
        return moviesRepository.updateMoviesListByKeyword(params.searchField)
    }
}
