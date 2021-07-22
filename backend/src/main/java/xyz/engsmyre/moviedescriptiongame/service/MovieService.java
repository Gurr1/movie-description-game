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
    private final ImdbDatasetService imdbDatasetService;

    public MovieService(MovieRepository movieRepository,
                        ImdbScraperService imdbScraperService,
                        ImdbDatasetService imdbDatasetService) {
        this.movieRepository = movieRepository;
        this.imdbScraperService = imdbScraperService;
        this.imdbDatasetService = imdbDatasetService;
    }

    public void updateMovies() throws {
        Map<String, Rating> ratingsMap = imdbDatasetService.getRatings();
        Map<String, Title> titles = imdbDatasetService.getTitles();
        List<Movie> movies = new ArrayList<>();
        titles.forEach((id, title) -> {
            Rating rating = ratingsMap.get(id);
            Movie movie = createMovieObject(title, rating);
            movies.add(movie);
        });
        movieRepository.saveAll(movies);
    }

    public Movie createMovieObject(Title title, Rating rating) {
        String description = imdbScraperService.getDescription(rating.getId());
        return new Movie(title.getId(), rating.getnVotes(), rating.getRating(),
                title.getOriginalTitle(), title.getPrimaryTitle(), description);
    }

}
