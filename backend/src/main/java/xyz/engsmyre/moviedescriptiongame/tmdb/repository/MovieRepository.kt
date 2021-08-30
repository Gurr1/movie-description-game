package xyz.engsmyre.moviedescriptiongame.tmdb.repository

import xyz.engsmyre.moviedescriptiongame.tmdb.domain.Movie

interface MovieRepository {
    fun getPopularMoviesFromPage(page : Int): List<Movie?>? // TODO Not hardcoded popular
    val popularMoviesPageCount: Int
}