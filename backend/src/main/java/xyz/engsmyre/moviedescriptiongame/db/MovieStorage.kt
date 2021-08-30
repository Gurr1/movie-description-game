package xyz.engsmyre.moviedescriptiongame.db

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed
import xyz.engsmyre.moviedescriptiongame.tmdb.domain.Movie
import java.io.Serializable

@RedisHash("Movie")
data class MovieStorage(private val movie : Movie, @Id @Indexed private val storageKey : String) : Serializable {
    fun storageKey() : String {
        return storageKey
    }

    fun getMovie() : Movie {
        return movie
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MovieStorage

        if (movie != other.movie) return false
        if (storageKey != other.storageKey) return false

        return true
    }

    override fun hashCode(): Int {
        var result = movie.hashCode()
        result = 31 * result + storageKey.hashCode()
        return result
    }

    override fun toString(): String {
        return "MovieStorage(movie=$movie, storageKey='$storageKey')"
    }
}