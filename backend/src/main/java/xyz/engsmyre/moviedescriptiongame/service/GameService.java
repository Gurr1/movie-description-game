package xyz.engsmyre.moviedescriptiongame.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;
import xyz.engsmyre.moviedescriptiongame.db.GameSessionMovies;
import xyz.engsmyre.moviedescriptiongame.db.MovieStorage;
import xyz.engsmyre.moviedescriptiongame.dto.GameId;
import xyz.engsmyre.moviedescriptiongame.dto.MovieDescription;
import xyz.engsmyre.moviedescriptiongame.repository.GameSessionRepository;
import xyz.engsmyre.moviedescriptiongame.repository.MovieStoreRepository;
import xyz.engsmyre.moviedescriptiongame.tmdb.domain.Movie;
import xyz.engsmyre.moviedescriptiongame.tmdb.service.MovieService;

@Service
public class GameService {

    private final MovieService movieService;
    private final MovieStoreRepository movieStoreRepository;
    private final GameSessionRepository gameSessionRepository;


    public GameService(MovieService movieService,
                       MovieStoreRepository movieStoreRepository,
                       GameSessionRepository gameSessionRepository) {
        this.movieService = movieService;
        this.movieStoreRepository = movieStoreRepository;
        this.gameSessionRepository = gameSessionRepository;
    }

    public GameId generateNewGame() {
        GameId gameId = new GameId(UUID.randomUUID());
        GameSessionMovies sessionMovies = new GameSessionMovies(gameId);
        gameSessionRepository.save(sessionMovies);
        return gameId;       // TODO In multiplayer, the ids should be stored and generated as 5-6 char code.
    }

    // TODO Should take which the current session is

    /**
     * fetches a random movie and stores in the database
     * with the current session as key.
     */
    public void nextMovie(GameId gameSessionId) {
        Movie nextMovie = movieService.getRandomMovie();
        MovieStorage movieWithStorageKey = new MovieStorage(nextMovie, "test");
        movieStoreRepository.save(movieWithStorageKey);
        GameSessionMovies gameSession = gameSessionRepository.findById(gameSessionId)
                .orElseThrow();
        GameSessionMovies updatedGameSession = new GameSessionMovies(gameSession, movieWithStorageKey);
        this.gameSessionRepository.save(updatedGameSession);
    }

    /**
     * Fetches the current movie for the session
     * from the database and extracts the description
     * @return The description of the current movie for the session
     */
    public MovieDescription getMovieDescription() {
        Iterable<MovieStorage> movies = movieStoreRepository.findAll();
        List<MovieStorage> storedMovies = StreamSupport.stream(movies.spliterator(), false)
                .collect(Collectors.toList());
        System.out.println(storedMovies);
        MovieStorage movie = movieStoreRepository.findMovieStorageByStorageKey("test")
                .orElseThrow();
        return new MovieDescription(movie.getMovie().getDescription());
    }
}
