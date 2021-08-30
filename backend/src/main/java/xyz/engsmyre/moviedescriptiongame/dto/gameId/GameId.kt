package xyz.engsmyre.moviedescriptiongame.dto.gameId

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.index.Indexed
import java.io.Serializable
import java.util.*

class GameId : Serializable {

    @Id
    @Indexed
    var gameId : UUID? = null
        private set

    constructor(gameId: UUID) {
        this.gameId = gameId
    }

    constructor()

    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        if (other == null || other.javaClass != this.javaClass) return false
        val that = other as GameId
        return gameId == that.gameId
    }

    override fun hashCode(): Int {
        return Objects.hash(gameId)
    }

    override fun toString(): String {
        return "GameId[" +
                "gameId=" + gameId + ']'
    }

    @Id
    fun gameId(): UUID? {
        return gameId
    }
}