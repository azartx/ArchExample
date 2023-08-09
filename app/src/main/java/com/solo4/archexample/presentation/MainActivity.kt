package com.solo4.archexample.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.solo4.archexample.R
import com.solo4.archexample.presentation.movieslist.MoviesListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launchInitialFragment()
    }

    private fun launchInitialFragment() {
        supportFragmentManager.commit {
            add(R.id.fragment_container, MoviesListFragment::class.java, null)
            addToBackStack(null)
        }
    }
}
