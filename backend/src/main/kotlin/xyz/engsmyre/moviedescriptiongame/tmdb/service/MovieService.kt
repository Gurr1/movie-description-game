package xyz.engsmyre.moviedescriptiongame.tmdb.service

import org.springframework.stereotype.Service
import xyz.engsmyre.moviedescriptiongame.tmdb.domain.Movie
import xyz.engsmyre.moviedescriptiongame.tmdb.repository.PopularMoviesRepository
import xyz.engsmyre.moviedescriptiongame.tmdb.repository.SearchableMovieRepository
import java.util.*
import kotlin.collections.ArrayList

@Service
class MovieService(private val popularMoviesRepository : PopularMoviesRepository,
                   private val searchableMoviesRepository: SearchableMovieRepository) {
    // TODO Add difficulty
    fun getRandomMovie() : Movie {//  TODO Add difficulty
        val r = Random()
        val pageCount = popularMoviesRepository.popularMoviesPageCount
        val randomPage = r.nextInt(pageCount) + 1
        val randomPageMovies = popularMoviesRepository.getPopularMoviesFromPage(randomPage)
        val randomMovieIndex = r.nextInt(randomPageMovies!!.size)
        return randomPageMovies[randomMovieIndex]!!
    }

    fun searchForMovies(movieQuery : String) : List<Movie> {
       return ArrayList<Movie>()
    }

}