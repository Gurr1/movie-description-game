package xyz.engsmyre.moviedescriptiongame.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.index.Indexed;
import xyz.engsmyre.moviedescriptiongame.dto.GameId;

public final class GameSessionMovies {
    private final List<MovieStorage> movies;
    @Id
    @Indexed
    private final GameId sessionId;

    public GameSessionMovies(GameId sessionId) {
        this(new ArrayList<MovieStorage>(), sessionId);
    }

    public GameSessionMovies(List<MovieStorage> movies, GameId sessionId) {
        this.movies = movies;
        this.sessionId = sessionId;
    }

    public GameSessionMovies(GameSessionMovies oldSession, MovieStorage newMovie) {
        List<MovieStorage> newMovieList = new ArrayList<>(oldSession.getMovies());
        newMovieList.add(newMovie);
        this.movies = newMovieList;
        this.sessionId = oldSession.getSessionId();
    }

    public List<MovieStorage> getMovies() {
        return movies;
    }

    public GameId getSessionId() {
        return sessionId;
    }


}
