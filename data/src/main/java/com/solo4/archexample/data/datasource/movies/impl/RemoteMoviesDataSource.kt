package com.solo4.archexample.data.datasource.movies.impl

import com.solo4.archexample.data.datasource.movies.MoviesDataSource
import com.solo4.archexample.data.datasource.network.MoviesApi
import com.solo4.archexample.data.model.MovieEntity
import com.solo4.archexample.data.model.SearchEntity

class RemoteMoviesDataSource(private val moviesApi: MoviesApi) : MoviesDataSource {
    override suspend fun getMoviesListByKeyword(keyword: String): MovieEntity {
        return moviesApi.getMoviesByKeyword(searchString = keyword)
    }

    override suspend fun getMovieById(id: Int): SearchEntity {
        return moviesApi.getMovieById(movieId = id)
    }
}
