package xyz.engsmyre.moviedescriptiongame.db

import org.springframework.data.redis.core.RedisHash
import xyz.engsmyre.moviedescriptiongame.tmdb.domain.Movie
import java.time.LocalDateTime

@RedisHash("MovieSuggestion")
data class MovieSuggestion (
    private val search : String,
    private val foundMovies : List<Movie>,
) {
    private var lastAccessed : LocalDateTime? = null
    init {
        lastAccessed = LocalDateTime.now()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MovieSuggestion

        if (search != other.search) return false
        if (foundMovies != other.foundMovies) return false
        if (lastAccessed != other.lastAccessed) return false

        return true
    }

    override fun hashCode(): Int {
        var result = search.hashCode()
        result = 31 * result + foundMovies.hashCode()
        result = 31 * result + (lastAccessed?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "MovieSuggestion(search='$search', foundMovies=$foundMovies, lastAccessed=$lastAccessed)"
    }


}