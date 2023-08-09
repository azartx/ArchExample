package com.solo4.archexample.data.datasource.network

import com.solo4.archexample.data.BuildConfig
import com.solo4.archexample.data.model.MovieEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {
    @GET("/")
    suspend fun getMoviesByKeyword(
        @Query("apikey") apiKey: String = BuildConfig.REMOTE_API_KEY,
        @Query("s") searchString: String
    ): MovieEntity

    @GET("/")
    suspend fun getMovieById(
        @Query("apikey") apiKey: String = BuildConfig.REMOTE_API_KEY,
        @Query("i") movieId: Int
    ): MovieEntity
}
