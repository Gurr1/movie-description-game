package xyz.engsmyre.moviedescriptiongame.tmdb.repository;

import java.util.List;
import xyz.engsmyre.moviedescriptiongame.tmdb.domain.Movie;

public interface MovieRepository {
    List<Movie> getPopularMoviesFromPage(int id);  // TODO Not hardcoded popular
    int getPopularMoviesPageCount();
}
