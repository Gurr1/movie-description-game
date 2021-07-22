package xyz.engsmyre.moviedescriptiongame.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import xyz.engsmyre.moviedescriptiongame.domain.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, String> {
    public Movie getById(String id);
}
