package xyz.engsmyre.moviedescriptiongame.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("Session")
public class GameSessionMovies implements Serializable {
    @Id
    @Indexed
    private UUID sessionId;
    private List<MovieStorage> movies;

    GameSessionMovies() {
        if (this.movies == null) {
            this.movies = new ArrayList<>();
        }
    }

    public GameSessionMovies(UUID sessionId) {
        this(new ArrayList<>(), sessionId);
    }

    public GameSessionMovies(List<MovieStorage> movies, UUID sessionId) {
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

    public UUID getSessionId() {
        return sessionId;
    }

    @Override
    public String toString() {
        return "GameSessionMovies{" +
                "sessionId=" + sessionId +
                ", movies=" + movies +
                '}';
    }
}
