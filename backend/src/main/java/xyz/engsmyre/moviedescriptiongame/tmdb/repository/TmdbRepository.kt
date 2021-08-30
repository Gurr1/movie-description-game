package xyz.engsmyre.moviedescriptiongame.tmdb.repository

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.util.MultiValueMap
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriBuilder
import xyz.engsmyre.moviedescriptiongame.tmdb.domain.Movie
import xyz.engsmyre.moviedescriptiongame.tmdb.domain.PopularMovieRequest
import xyz.engsmyre.moviedescriptiongame.tmdb.domain.TmdbMovieResponse
import xyz.engsmyre.moviedescriptiongame.tmdb.exception.TmdbCommunicationFailedException

@Component
class TmdbRepository(private val tmdbWebClient: WebClient) : MovieRepository {
    @Value("\${tmdb.api_key}")
    private val apiKey: String? = null

    @Value("\${tmdb.minimum_vote_count}") // TODO should not be set by an environment variable, but by difficulty.
    private val voteCount // Vote count is used to determine if a movie is considerred "known"
            = 0

    @Throws(TmdbCommunicationFailedException::class)
    override fun getPopularMoviesFromPage(page: Int): List<Movie?> {
        val webClientParams = PopularMovieRequest(
            apiKey!!,
            page,
            voteCount
        ).createParamsMap()
        try {
            val movieResponse = doBlockingDiscoveryRequest(webClientParams)
            if (movieResponse != null) {
                return movieResponse.movies!!
            }
            throw TmdbCommunicationFailedException("Could not communicate or deserialize response from TMDB")
        } catch (e: Exception) {
            throw TmdbCommunicationFailedException(e)
        }
    }

    // https://api.themoviedb.org/3/discover/movie?api_key={api_key}&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&vote_count.gte=3000
    @get:Throws(TmdbCommunicationFailedException::class)
    override val popularMoviesPageCount: Int
        get() {
            val webClientParams = PopularMovieRequest(apiKey!!, voteCount).createParamsMap()
            try {
                val movieResponse = doBlockingDiscoveryRequest(webClientParams)
                if (movieResponse != null) {
                    return movieResponse.getnPages()
                }
                throw TmdbCommunicationFailedException("Could not communicate or deserialize response from TMDB")
            } catch (e: Exception) {
                throw TmdbCommunicationFailedException(e.message)
            }
        }

    private fun doBlockingDiscoveryRequest(webClientParams: MultiValueMap<String, String>): TmdbMovieResponse? {
        return tmdbWebClient.get()
            .uri { uriBuilder: UriBuilder -> uriBuilder.queryParams(webClientParams).build() }
            .retrieve()
            .bodyToMono(TmdbMovieResponse::class.java)
            .block()
    }
}