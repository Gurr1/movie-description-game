package xyz.engsmyre.moviedescriptiongame.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import xyz.engsmyre.moviedescriptiongame.domain.Movie;
import xyz.engsmyre.moviedescriptiongame.domain.Rating;
import xyz.engsmyre.moviedescriptiongame.domain.Title;
import xyz.engsmyre.moviedescriptiongame.repository.MovieRepository;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final ImdbScraperService imdbScraperService;

    public MovieService(MovieRepository movieRepository, ImdbScraperService imdbScraperService) {
        this.movieRepository = movieRepository;
        this.imdbScraperService = imdbScraperService;
    }

    public boolean updateMovies(Map<String, Title> titles, Map<String, Rating> ratingsMap) {
        List<Movie> movies = new ArrayList<>();
        titles.forEach((id, title) -> {
            Rating rating = ratingsMap.get(id);
            Movie movie = createMovieObject(title, rating);
            movies.add(movie);
        });
        movieRepository.saveAll(movies);
        return true;
    }

    public Movie createMovieObject(Title title, Rating rating) {
        String description = imdbScraperService.getDescription(rating.getId());
        return new Movie(title.getId(), rating.getnVotes(), rating.getRating(),
                title.getOriginalTitle(), title.getPrimaryTitle(), description);
    }

}
