package com.solo4.archexample.presentation.movieslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.solo4.archexample.databinding.FragmentMoviesListBinding
import com.solo4.archexample.presentation.movieslist.adapters.MovieListAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesListFragment : Fragment() {
    private val moviesAdapter: MovieListAdapter by lazy { MovieListAdapter() }

    private lateinit var binding: FragmentMoviesListBinding

    private val viewModel by viewModel<MovieListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesListBinding.inflate(layoutInflater, null, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerMoviesList.adapter = moviesAdapter

        initReceivers()
    }

    private fun initReceivers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.moviesFlow.collectLatest {
                    moviesAdapter.currentList = it
                }
            }
        }
    }
}