package xyz.engsmyre.moviedescriptiongame.dto.gameId;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.index.Indexed;


public final class GameId implements Serializable {
    @Serial
    private static final long serialVersionUID = 0L;
    @Id
    @Indexed
    private UUID gameId;

    public GameId(UUID gameId) {
        this.gameId = gameId;
    }

    protected GameId() {
    }

    public UUID getGameId() {
        return gameId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (GameId) obj;
        return Objects.equals(this.gameId, that.gameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId);
    }

    @Override
    public String toString() {
        return "GameId[" +
                "gameId=" + gameId + ']';
    }

    @Id
    public UUID gameId() {
        return gameId;
    }


}
