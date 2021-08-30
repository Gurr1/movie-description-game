package xyz.engsmyre.moviedescriptiongame.service

import org.springframework.stereotype.Service
import xyz.engsmyre.moviedescriptiongame.db.GameSessionMovies
import xyz.engsmyre.moviedescriptiongame.db.MovieStorage
import xyz.engsmyre.moviedescriptiongame.dto.MovieDescription
import xyz.engsmyre.moviedescriptiongame.dto.gameId.GameId
import xyz.engsmyre.moviedescriptiongame.repository.GameSessionRepository
import xyz.engsmyre.moviedescriptiongame.repository.MovieStoreRepository
import xyz.engsmyre.moviedescriptiongame.tmdb.service.MovieService
import java.util.*
import java.util.stream.Collectors
import java.util.stream.StreamSupport

@Service
class GameService(
    private val movieService: MovieService,
    private val movieStoreRepository: MovieStoreRepository,
    private val gameSessionRepository: GameSessionRepository
) {
    fun generateNewGameId(): GameId {
        return GameId(UUID.randomUUID())
        // TODO In multiplayer, the ids should be stored and generated as 5-6 char code and mapped internally to the UUID
    }

    fun generateNewGame(gameId: GameId) {
        val sessionMovies = GameSessionMovies(gameId.gameId())
        gameSessionRepository.save(sessionMovies)
    }
    // TODO Should take which the current session is
    /**
     * fetches a random movie and stores in the database
     * with the current session as key.
     */
    fun nextMovie(gameSessionId: GameId) {
        val nextMovie = movieService.getRandomMovie()
        val movieWithStorageKey = MovieStorage(nextMovie, "test")
        movieStoreRepository.save(movieWithStorageKey)
        println(gameSessionRepository.findAll())
        val gameSession = gameSessionRepository.findById(gameSessionId.gameId())
            .orElseThrow()
        val updatedGameSession = GameSessionMovies(gameSession, movieWithStorageKey)
        gameSessionRepository.save(updatedGameSession)
    }

    /**
     * Fetches the current movie for the session
     * from the database and extracts the description
     * @return The description of the current movie for the session
     */
    fun getMovieDescription() : MovieDescription {
            val movies = movieStoreRepository.findAll()
            val storedMovies: List<MovieStorage> = StreamSupport.stream(movies.spliterator(), false)
                .collect(Collectors.toList())
            println(storedMovies)
            val movie = movieStoreRepository.findMovieStorageByStorageKey("test").orElseThrow()
            return MovieDescription(movie.getMovie().description!!)
        }
}