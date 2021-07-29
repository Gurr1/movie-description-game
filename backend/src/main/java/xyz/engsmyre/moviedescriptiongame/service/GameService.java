package xyz.engsmyre.moviedescriptiongame.service;

import org.springframework.stereotype.Service;
import xyz.engsmyre.moviedescriptiongame.dto.MovieDescription;
import xyz.engsmyre.moviedescriptiongame.tmdb.domain.Movie;
import xyz.engsmyre.moviedescriptiongame.tmdb.service.MovieService;

@Service
public class GameService {

    private MovieService movieService;

    public GameService(MovieService movieService) {
        this.movieService = movieService;
    }

    // TODO Should take which the current session is

    /**
     * fetches a random movie and stores in the database
     * with the current session as key.
     */
    public void nextMovie() {   // TODO Store movie details in redis
        Movie nextMovie = movieService.getRandomMovie();

    }

    /**
     * Fetches the current movie for the session
     * from the database and extracts the description
     * @return The description of the current movie for the session
     */
    public MovieDescription getMovieDescription() {
        return null;
    }
}
