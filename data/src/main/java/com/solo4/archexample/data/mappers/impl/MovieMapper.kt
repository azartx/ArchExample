package com.solo4.archexample.data.mappers.impl

import com.solo4.archexample.data.mappers.Transformable
import com.solo4.archexample.data.model.SearchEntity
import com.solo4.archexample.domain.usecase.movieslist.model.Movie

internal class MovieMapper : Transformable<SearchEntity, Movie> {
    override fun transformForward(from: SearchEntity): Movie {
        return from.let { searchEntity ->
            Movie(
                title = searchEntity.title,
                year = searchEntity.year,
                poster = searchEntity.poster
            )
        }
    }

    override fun transformBack(from: Movie): SearchEntity {
        return SearchEntity(
            title = from.title,
            year = from.year,
            imdbID = null,
            type = null,
            poster = from.poster
        )
    }
}
