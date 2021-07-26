package xyz.engsmyre.moviedescriptiongame.tmdb.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Movie")
public class Movie implements Serializable {

    @JsonProperty("id")
    private int id;
    @JsonProperty("vote_count")
    private int nVotes;
    @JsonProperty("vote_average")
    private double rating;
    @JsonProperty("original_title")
    private String originalTitle;
    @JsonProperty("title")
    private String title;
    @JsonProperty("overview")
    private String description;
    @JsonProperty("release_date")
    private LocalDate releaseDate;

    public Movie() {    // Only for deserializing purposes
    }

    public int getId() {
        return id;
    }

    public int getnVotes() {
        return nVotes;
    }

    public double getRating() {
        return rating;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getPrimaryTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return nVotes == movie.nVotes && Double.compare(movie.rating, rating) == 0 && Objects.equals(id, movie.id) && Objects.equals(originalTitle, movie.originalTitle) && Objects.equals(title, movie.title) && Objects.equals(description, movie.description) && Objects.equals(releaseDate, movie.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nVotes, rating, originalTitle, title, description, releaseDate);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", nVotes=" + nVotes +
                ", rating=" + rating +
                ", originalTitle='" + originalTitle + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
