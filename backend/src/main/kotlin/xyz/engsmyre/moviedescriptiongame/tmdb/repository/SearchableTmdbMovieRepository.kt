package xyz.engsmyre.moviedescriptiongame.tmdb.repository

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import xyz.engsmyre.moviedescriptiongame.tmdb.domain.Movie

@Component
class SearchableTmdbMovieRepository(@Qualifier("TmdbSearchClient") private val tmdbWebClient : WebClient)
    : SearchableMovieRepository {
    override fun searchByName(partialName: String): List<Movie> {

        TODO("Not yet implemented")
    }

}