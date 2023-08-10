package com.solo4.archexample.presentation.movieslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solo4.archexample.domain.usecase.movieslist.MoviesListUseCase
import com.solo4.archexample.domain.usecase.movieslist.model.Movie
import com.solo4.archexample.domain.usecase.movieslist.model.MoviesListParams
import com.solo4.archexample.presentation.model.movieslist.MovieItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch

class MovieListViewModel(private val moviesListUseCase: MoviesListUseCase) : ViewModel() {

    val moviesFlow = moviesListUseCase.moviesFlow
        .map { it.map { movie -> movieToAdapterModel(movie) } }
        .flowOn(Dispatchers.Default)
        .shareIn(viewModelScope, SharingStarted.Lazily)

    init {
        viewModelScope.launch {
            moviesListUseCase.execute(
                MoviesListParams("Matrix")
            )
        }

    }

    private fun movieToAdapterModel(movie: Movie) = MovieItem(
        title = movie.title ?: "No title",
        description = movie.title ?: "No description",
        imageUrl = movie.poster
            ?: "https://st3.depositphotos.com/17828278/33150/v/450/depositphotos_331503262-stock-illustration-no-image-vector-symbol-missing.jpg"
    )
}
