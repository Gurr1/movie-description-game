package xyz.engsmyre.moviedescriptiongame.db

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed
import java.io.Serializable
import java.util.*

@RedisHash("Session")
class GameSessionMovies : Serializable {
    @Id
    @Indexed
    var sessionId: UUID? = null
        private set
    var movies: List<MovieStorage>? = null
        private set

    internal constructor() {
        if (movies == null) {
            movies = ArrayList()
        }
    }

    constructor(sessionId: UUID?) : this(ArrayList<MovieStorage>(), sessionId) {}
    constructor(movies: List<MovieStorage>?, sessionId: UUID?) {
        this.movies = movies
        this.sessionId = sessionId
    }

    constructor(oldSession: GameSessionMovies, newMovie: MovieStorage) {
        val newMovieList: MutableList<MovieStorage> = ArrayList(oldSession.movies)
        newMovieList.add(newMovie)
        movies = newMovieList
        sessionId = oldSession.sessionId
    }

    override fun toString(): String {
        return "GameSessionMovies(sessionId=$sessionId, movies=$movies)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GameSessionMovies

        if (sessionId != other.sessionId) return false
        if (movies != other.movies) return false

        return true
    }

    override fun hashCode(): Int {
        var result = sessionId?.hashCode() ?: 0
        result = 31 * result + (movies?.hashCode() ?: 0)
        return result
    }


}