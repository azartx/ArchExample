package com.solo4.archexample.data.mappers

interface Transformable<T1, T2> {
    fun transformForward(from: T1): T2
    fun transformBack(from: T2): T1
}
