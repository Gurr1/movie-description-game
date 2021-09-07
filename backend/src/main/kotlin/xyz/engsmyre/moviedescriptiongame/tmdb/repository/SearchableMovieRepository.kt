package xyz.engsmyre.moviedescriptiongame.tmdb.repository

import xyz.engsmyre.moviedescriptiongame.tmdb.domain.Movie

interface SearchableMovieRepository {
    fun searchByName(partialName : String) : List<Movie>
}