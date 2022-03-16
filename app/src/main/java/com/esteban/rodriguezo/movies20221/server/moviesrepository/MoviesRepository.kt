package com.esteban.rodriguezo.movies20221.server.moviesrepository

import com.esteban.rodriguezo.movies20221.server.MovieDB
import com.esteban.rodriguezo.movies20221.server.model.Movie

class MoviesRepository {
    private val apiKey = "3a783517bb2ed1f3ad35100e58882ddc"

    suspend fun getMovies() = MovieDB.retrofit.getTopRated(apiKey)
}