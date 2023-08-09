package com.solo4.archexample.presentation.movieslist.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.solo4.archexample.databinding.ItemRecyclerviewMovieBinding
import com.solo4.archexample.presentation.model.movieslist.MovieItem

class MovieListAdapter : RecyclerView.Adapter<MovieListViewHolder>() {

    private val differ = object : DiffUtil.ItemCallback<MovieItem>() {
        override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem == newItem
        }
    }

    private val asyncDiffer = AsyncListDiffer(this, differ)

    var currentList: List<MovieItem>
        set(value) {
            asyncDiffer.submitList(value.toMutableList())
        }
        get() { return asyncDiffer.currentList }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        return MovieListViewHolder(
            ItemRecyclerviewMovieBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.bind(currentList.getOrNull(position) ?: throw Exception())
    }

    override fun getItemCount(): Int {
        return currentList.size
    }
}
