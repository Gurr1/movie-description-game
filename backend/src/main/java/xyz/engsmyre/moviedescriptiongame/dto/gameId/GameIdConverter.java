package xyz.engsmyre.moviedescriptiongame.dto.gameId;

import java.util.UUID;
import org.springframework.core.convert.converter.Converter;

public class GameIdConverter implements Converter<String, GameId> {
    @Override
    public GameId convert(String source) {
        try {
            UUID gameUUID = UUID.fromString(source);
            return new GameId(gameUUID);
        } catch (IllegalArgumentException e) {
            System.out.println("could not convert from String to GameId, internal error: " + e.getMessage());
            throw new IllegalArgumentException(e);
        }
    }
}
