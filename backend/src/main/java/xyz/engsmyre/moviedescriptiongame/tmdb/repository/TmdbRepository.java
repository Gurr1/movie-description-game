package xyz.engsmyre.moviedescriptiongame.tmdb.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import xyz.engsmyre.moviedescriptiongame.tmdb.domain.Movie;
import xyz.engsmyre.moviedescriptiongame.tmdb.domain.PopularMovieRequest;
import xyz.engsmyre.moviedescriptiongame.tmdb.domain.TmdbMovieResponse;
import xyz.engsmyre.moviedescriptiongame.tmdb.exception.TmdbCommunicationFailedException;

@Component
public class TmdbRepository implements MovieRepository {

    @Value("@{tmdb.api_key}")
    private String apiKey;
    private final WebClient tmdbWebClient;

    public TmdbRepository(WebClient tmdbWebClient) {
        this.tmdbWebClient = tmdbWebClient;
    }

    @Override
    public Movie getPopularMoviesFromPage(int page) {
        return null;
    }

    // https://api.themoviedb.org/3/discover/movie?api_key={api_key}&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&vote_count.gte=3000
    @Override
    public int getPopularMoviesPageCount() throws TmdbCommunicationFailedException {
        MultiValueMap<String, String> webClientParams = new PopularMovieRequest(apiKey).createParamsMap();
        try {
            TmdbMovieResponse movieResponse = tmdbWebClient.get()
                    .uri(uriBuilder -> uriBuilder.queryParams(webClientParams).build())
                    .retrieve()
                    .bodyToMono(TmdbMovieResponse.class)
                    .block();
            if (movieResponse != null) {
                return movieResponse.getnPages();
            }
            throw new TmdbCommunicationFailedException("Could not communicate or deserialize response from TMDB");
        } catch (Exception e) {
            throw new TmdbCommunicationFailedException(e.getMessage());
        }
    }
}
