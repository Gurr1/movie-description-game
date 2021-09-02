package xyz.engsmyre.moviedescriptiongame.dto.gameId

import org.springframework.core.convert.converter.Converter
import java.util.*

class GameIdConverter : Converter<String?, GameId> {
    override fun convert(source: String?): GameId {
        return try {
            val gameUUID = UUID.fromString(source)
            GameId(gameUUID)
        } catch (e: IllegalArgumentException) {
            println("could not convert from String to GameId, internal error: ${e.message}")
            throw IllegalArgumentException(e)
        }
    }
}