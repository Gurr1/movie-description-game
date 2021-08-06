package xyz.engsmyre.moviedescriptiongame.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.engsmyre.moviedescriptiongame.db.GameSessionMovies;
import xyz.engsmyre.moviedescriptiongame.dto.GameId;

@Repository
public interface GameSessionRepository extends CrudRepository<GameSessionMovies, GameId> {

}
