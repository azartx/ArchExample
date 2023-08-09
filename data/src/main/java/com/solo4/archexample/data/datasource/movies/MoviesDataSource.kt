package com.solo4.archexample.data.datasource.movies

import com.solo4.archexample.data.model.MovieEntity

interface MoviesDataSource {
    suspend fun getMoviesListByKeyword(keyword: String): MovieEntity
    suspend fun getMovieById(id: Int): MovieEntity
}
