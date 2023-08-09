package com.solo4.archexample.domain.di

import com.solo4.archexample.domain.usecase.movieslist.MoviesListUseCase
import com.solo4.archexample.domain.usecase.movieslist.impl.MoviesListUseCaseImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val domainModule = module {
    factory { MoviesListUseCaseImpl(get()) } bind MoviesListUseCase::class
}
