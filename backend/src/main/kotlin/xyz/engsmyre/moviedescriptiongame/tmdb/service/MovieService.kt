package xyz.engsmyre.moviedescriptiongame.tmdb.service

import org.springframework.stereotype.Service
import xyz.engsmyre.moviedescriptiongame.tmdb.domain.Movie
import xyz.engsmyre.moviedescriptiongame.tmdb.repository.MovieRepository
import java.util.*

@Service
class MovieService(private val movieRepository: MovieRepository) {
    // TODO Add difficulty
    fun getRandomMovie() : Movie {//  TODO Add difficulty
        val r = Random()
        val pageCount = movieRepository.popularMoviesPageCount
        val randomPage = r.nextInt(pageCount) + 1
        val randomPageMovies = movieRepository.getPopularMoviesFromPage(randomPage)
        val randomMovieIndex = r.nextInt(randomPageMovies!!.size)
        return randomPageMovies[randomMovieIndex]!!
    }}