package com.solo4.archexample.data.repository

import com.solo4.archexample.data.datasource.movies.MoviesDataSource
import com.solo4.archexample.data.mappers.Transformable
import com.solo4.archexample.data.model.SearchEntity
import com.solo4.archexample.domain.usecase.movieslist.model.Movie
import com.solo4.archexample.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class MoviesRepositoryImpl(
    private val moviesDataSource: MoviesDataSource,
    private val moviesMapper: Transformable<SearchEntity, Movie>
) : MoviesRepository {

    private val _moviesListFlow = MutableSharedFlow<List<Movie>>(extraBufferCapacity = 1)
    override val movies: SharedFlow<List<Movie>> = _moviesListFlow.asSharedFlow()

    override suspend fun updateMoviesListByKeyword(keyword: String): Result<Unit> {
        return runCatching {
            val result = moviesDataSource
                .getMoviesListByKeyword(keyword)
                .search
                .map { moviesMapper.transformForward(it) }
            _moviesListFlow.emit(result)
        }
    }

    override suspend fun getMovieById(id: Int): Result<Movie> {
        return runCatching {
            moviesMapper.transformForward(moviesDataSource.getMovieById(id))
        }
    }
}
