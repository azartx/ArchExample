package com.solo4.archexample.data.di

import com.google.gson.Gson
import com.solo4.archexample.data.datasource.movies.MoviesDataSource
import com.solo4.archexample.data.datasource.movies.impl.RemoteMoviesDataSource
import com.solo4.archexample.data.datasource.network.MoviesApi
import com.solo4.archexample.data.repository.MoviesRepositoryImpl
import com.solo4.archexample.domain.repository.MoviesRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    includes(mappersModule)

    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://www.omdbapi.com")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
    }

    fun provideMoviesApi(retrofit: Retrofit): MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }

    single { provideRetrofit() }
    single { provideMoviesApi(get()) }

    factory { RemoteMoviesDataSource(moviesApi = get()) } bind MoviesDataSource::class
    factory {
        MoviesRepositoryImpl(
            moviesDataSource = get(),
            moviesMapper = get(qualifier = movieMapperQualifier)
        )
    } bind MoviesRepository::class
}
