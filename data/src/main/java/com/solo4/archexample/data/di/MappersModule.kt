package com.solo4.archexample.data.di

import com.solo4.archexample.data.mappers.Transformable
import com.solo4.archexample.data.mappers.impl.MovieMapper
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.bind
import org.koin.dsl.module

internal val movieMapperQualifier = StringQualifier("movieMapperQualifier")

val mappersModule = module {
    factory(qualifier = movieMapperQualifier) { MovieMapper() } bind Transformable::class
}
