package com.solo4.archexample.di

import com.solo4.archexample.presentation.moviesdetails.MovieDetailsViewModel
import com.solo4.archexample.presentation.movieslist.MovieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MovieDetailsViewModel() }
    viewModel { MovieListViewModel(get()) }
}
