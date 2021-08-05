package xyz.engsmyre.moviedescriptiongame.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.engsmyre.moviedescriptiongame.db.MovieStorage;

@Repository
public interface MovieStoreRepository extends CrudRepository<MovieStorage, String> {
    Optional<MovieStorage> findMovieStorageByStorageKey(String key);
}
