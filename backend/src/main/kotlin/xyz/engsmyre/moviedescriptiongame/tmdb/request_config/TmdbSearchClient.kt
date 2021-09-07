package xyz.engsmyre.moviedescriptiongame.tmdb.request_config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Configuration
open class TmdbSearchClient {
    @Bean("TmdbSearchClient")
    open fun tmdbWebClient(): WebClient {     // TODO Look over how the client can be configured
        return WebClient.builder()
            .baseUrl("https://api.themoviedb.org/3/search/movie")
            .defaultUriVariables(
                mapOf<String, String>(
                    "language" to "en-US&",
                    "sort_by" to "popularity.desc",
                    "include_adult" to "false",
                    "include_video" to "false"
                )
            ).build()
    }
}