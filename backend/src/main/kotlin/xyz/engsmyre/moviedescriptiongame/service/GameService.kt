package xyz.engsmyre.moviedescriptiongame.service

import org.springframework.stereotype.Service
import xyz.engsmyre.moviedescriptiongame.db.GameSessionMovies
import xyz.engsmyre.moviedescriptiongame.db.MovieStorage
import xyz.engsmyre.moviedescriptiongame.dto.MovieDescription
import xyz.engsmyre.moviedescriptiongame.dto.UserGuess
import xyz.engsmyre.moviedescriptiongame.dto.gameId.GameId
import xyz.engsmyre.moviedescriptiongame.repository.GameSessionRepository
import xyz.engsmyre.moviedescriptiongame.tmdb.domain.Movie
import xyz.engsmyre.moviedescriptiongame.tmdb.service.MovieService
import java.util.*
import java.util.stream.Collectors
import java.util.stream.StreamSupport

@Service
class GameService(
    private val movieService: MovieService,
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
        val gameSession = gameSessionRepository.findById(gameSessionId.gameId()!!)
            .orElseThrow()
        val storedNextMovie = MovieStorage(nextMovie);
        val updatedGameSession = GameSessionMovies(gameSession, storedNextMovie)
        gameSessionRepository.save(updatedGameSession)
    }

    /**
     * Fetches the current movie for the session
     * from the database and extracts the description
     * @return The description of the current movie for the session
     */
    fun getMovieDescription(gameSessionId: GameId): MovieDescription {
        val sessionLastMovie = currentSessionLastMovie(gameSessionId)
        return MovieDescription(sessionLastMovie.description!!)
    }


    fun guessMovie(guess: UserGuess) : Boolean {
        val gameId = guess.gameId
        var movieGuess = guess.movieGuess
        movieGuess = movieGuess.toLowerCase()
        val sessionLastMovie = currentSessionLastMovie(gameId);
        return isSameMovie(movieGuess, sessionLastMovie)
        TODO("This should search for the movie's TMDB ID instead of name")
    }

    private fun currentSessionLastMovie(gameSessionId: GameId) : Movie {
        val sessionMovies = gameSessionRepository.findGameSessionMoviesBySessionId(gameSessionId.gameId)
            .orElseThrow()
        return sessionMovies.movies!!.last().getMovie()
    }

    private fun isSameMovie(movieName : String, movieObject : Movie) : Boolean {
        return movieObject.primaryTitle!! === movieName
                || movieObject.originalTitle!! === movieName
    }
}