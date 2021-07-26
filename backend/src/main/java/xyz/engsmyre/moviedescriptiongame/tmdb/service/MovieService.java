package xyz.engsmyre.moviedescriptiongame.tmdb.service;

import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;
import xyz.engsmyre.moviedescriptiongame.tmdb.domain.Movie;
import xyz.engsmyre.moviedescriptiongame.tmdb.repository.MovieRepository;


@Service
public class MovieService {

    private final MovieRepository movieRepository;


    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie getRandomMovie() {     // TODO Add difficulty
        Random r = new Random();
        int pageCount = movieRepository.getPopularMoviesPageCount();
        int randomPage = r.nextInt(pageCount) + 1;
        List<Movie> randomPageMovies = movieRepository.getPopularMoviesFromPage(randomPage);
        int randomMovieIndex = r.nextInt(randomPageMovies.size());
        return randomPageMovies.get(randomMovieIndex);
    }

}
