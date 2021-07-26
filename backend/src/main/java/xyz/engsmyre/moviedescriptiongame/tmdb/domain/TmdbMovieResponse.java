package xyz.engsmyre.moviedescriptiongame.tmdb.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

public class TmdbMovieResponse {

    @JsonProperty("total_pages")
    private int nPages;
    @JsonProperty("total_results")
    private int nResults;
    @JsonProperty("page")
    private int page;
    @JsonProperty("results")
    private List<Movie> movies;

    public TmdbMovieResponse() {
    }

    public int getnPages() {
        return nPages;
    }

    public int getnResults() {
        return nResults;
    }

    public int getPage() {
        return page;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TmdbMovieResponse that = (TmdbMovieResponse) o;
        return nPages == that.nPages && nResults == that.nResults && page == that.page && Objects.equals(movies, that.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nPages, nResults, page, movies);
    }

    @Override
    public String toString() {
        return "TmdbMovieResponse{" +
                "nPages=" + nPages +
                ", nResults=" + nResults +
                ", page=" + page +
                ", movies=" + movies +
                '}';
    }
}
