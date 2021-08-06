package xyz.engsmyre.moviedescriptiongame.dto;

import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.index.Indexed;


public record GameId(@Id @Indexed UUID gameId) {

    public UUID getGameId() {
        return gameId;
    }
}
