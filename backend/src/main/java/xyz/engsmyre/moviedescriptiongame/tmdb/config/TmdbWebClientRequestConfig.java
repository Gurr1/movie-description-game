package xyz.engsmyre.moviedescriptiongame.tmdb.config;

import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class TmdbWebClientRequestConfig {

    @Bean
    public WebClient tmdbWebClient() {     // TODO Look over how the client can be configured
        return WebClient.builder()
                .baseUrl("https://api.themoviedb.org/3/discover/movie")
                .defaultUriVariables(Map.of(
                        "language", "en-US&",
                        "sort_by", "popularity.desc",
                        "include_adult", "false",
                        "include_video", "false"
                ))
                .build();
    }
}
