package com.solo4.archexample.data.repository

import com.solo4.archexample.data.datasource.movies.MoviesDataSource
import com.solo4.archexample.data.model.RatingEntity
import com.solo4.archexample.data.model.SearchEntity
import com.solo4.archexample.domain.usecase.movieslist.model.Movie
import com.solo4.archexample.domain.repository.MoviesRepository
import com.solo4.archexample.domain.usecase.movieslist.model.Rating
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class MoviesRepositoryImpl(private val moviesDataSource: MoviesDataSource) : MoviesRepository {

    private val _moviesListFlow = MutableSharedFlow<List<Movie>>(extraBufferCapacity = 1)

    override fun updateMoviesListByKeyword(keyword: String): Flow<List<Movie>> {
        return _moviesListFlow.asSharedFlow().apply {
            CoroutineScope(Dispatchers.IO).launch {
                _moviesListFlow.emit(
                    moviesDataSource.getMoviesListByKeyword(keyword).search.map { mapMovieToDomain(it) }
                )
            }
        }
    }

    override suspend fun getMovieById(id: Int): Movie {
        throw Exception()
    }

    private fun mapMovieToDomain(searchEntity: SearchEntity) = Movie(
        title = searchEntity.title,
        year = searchEntity.year,
        poster = searchEntity.poster
    )

    private fun mapRatingToDomain(ratingEntity: RatingEntity) = Rating(
        source = ratingEntity.source,
        value = ratingEntity.value
    )
}
