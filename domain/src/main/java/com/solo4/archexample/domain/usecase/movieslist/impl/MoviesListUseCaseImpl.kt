package com.solo4.archexample.domain.usecase.movieslist.impl

import com.solo4.archexample.domain.usecase.movieslist.model.Movie
import com.solo4.archexample.domain.usecase.movieslist.model.MoviesListParams
import com.solo4.archexample.domain.repository.MoviesRepository
import com.solo4.archexample.domain.usecase.movieslist.MoviesListUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MoviesListUseCaseImpl(private val moviesRepository: MoviesRepository) : MoviesListUseCase {
    override fun execute(params: MoviesListParams): Flow<List<Movie>> {
        return moviesRepository.updateMoviesListByKeyword(params.searchField)
    }
}
