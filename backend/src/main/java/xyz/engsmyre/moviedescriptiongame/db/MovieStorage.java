package xyz.engsmyre.moviedescriptiongame.db;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;
import xyz.engsmyre.moviedescriptiongame.tmdb.domain.Movie;

@RedisHash("Movie")
public record MovieStorage(Movie movie,
                           @Id @Indexed String storageKey) implements Serializable {
    @Serial
    private static final long serialVersionUID = 0L;

    public Movie getMovie() {
        return movie;
    }

    public String getStorageKey() {
        return storageKey;
    }

    @Override
    public String storageKey() {
        return storageKey;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (MovieStorage) obj;
        return Objects.equals(this.movie, that.movie) &&
                Objects.equals(this.storageKey, that.storageKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie, storageKey);
    }

    @Override
    public String toString() {
        return "MovieStorage[" +
                "movie=" + movie + ", " +
                "storageKey=" + storageKey + ']';
    }

}
