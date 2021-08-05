package xyz.engsmyre.moviedescriptiongame.dto;

import java.util.UUID;

public record GameId(UUID gameId) {

    public UUID getGameId() {
        return gameId;
    }
}
