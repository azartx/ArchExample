package com.solo4.archexample.presentation.movieslist.adapters

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.solo4.archexample.databinding.ItemRecyclerviewMovieBinding
import com.solo4.archexample.presentation.model.movieslist.MovieItem

class MovieListViewHolder(private val binding: ItemRecyclerviewMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MovieItem) {
        binding.imageviewMoviewImage.load(item.imageUrl) {
            scale(Scale.FILL)
        }
        binding.textviewMovieTitle.text = item.title
    }
}