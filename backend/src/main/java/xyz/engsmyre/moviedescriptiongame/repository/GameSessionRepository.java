package xyz.engsmyre.moviedescriptiongame.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.engsmyre.moviedescriptiongame.db.GameSessionMovies;

@Repository
public interface GameSessionRepository extends CrudRepository<GameSessionMovies, UUID> {
    Optional<GameSessionMovies> findGameSessionMoviesBySessionId(UUID gameId);
}
