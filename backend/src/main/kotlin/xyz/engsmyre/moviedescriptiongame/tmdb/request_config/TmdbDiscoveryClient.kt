package xyz.engsmyre.moviedescriptiongame.tmdb.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
open class TmdbWebClientRequestConfig {
    @Bean
    open fun tmdbWebClient(): WebClient {     // TODO Look over how the client can be configured
        return WebClient.builder()
            .baseUrl("https://api.themoviedb.org/3/discover/movie")
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