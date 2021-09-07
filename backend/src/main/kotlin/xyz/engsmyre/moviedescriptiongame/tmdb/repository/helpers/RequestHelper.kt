package xyz.engsmyre.moviedescriptiongame.tmdb.repository.helpers

import org.springframework.util.MultiValueMap
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriBuilder
import xyz.engsmyre.moviedescriptiongame.tmdb.domain.TmdbMovieResponse
import xyz.engsmyre.moviedescriptiongame.tmdb.exception.TmdbCommunicationFailedException

object RequestHelper {

    fun doBlockingDiscoveryRequest(webClientParams: MultiValueMap<String, String>,
                                    tmdbWebClient: WebClient): TmdbMovieResponse {
        try {
            val movieResponse = createBlockingDiscoveryRequest(webClientParams, tmdbWebClient)
            if (movieResponse != null) {
                return movieResponse
            }
            throw TmdbCommunicationFailedException("Could not communicate or deserialize response from TMDB")
        } catch (e: Exception) {
            throw TmdbCommunicationFailedException(e.message)
        }
    }

    private fun createBlockingDiscoveryRequest(webClientParams: MultiValueMap<String, String>,
                                               tmdbWebClient : WebClient): TmdbMovieResponse? {
        return tmdbWebClient.get()
            .uri { uriBuilder: UriBuilder -> uriBuilder.queryParams(webClientParams).build() }
            .retrieve()
            .bodyToMono(TmdbMovieResponse::class.java)
            .block()
    }
}