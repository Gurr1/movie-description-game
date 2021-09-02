package xyz.engsmyre.moviedescriptiongame.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import xyz.engsmyre.moviedescriptiongame.db.GameSessionMovies
import java.util.*

@Repository
interface GameSessionRepository : CrudRepository<GameSessionMovies, UUID?> {
    fun findGameSessionMoviesBySessionId(gameId: UUID?): Optional<GameSessionMovies>
}