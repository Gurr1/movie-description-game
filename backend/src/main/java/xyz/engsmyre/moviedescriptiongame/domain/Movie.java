package xyz.engsmyre.moviedescriptiongame.domain;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Movie")
public class Movie {

    private final String id;
    private final int nVotes;
    private final double rating;
    private final String originalTitle;
    private final String primaryTitle;
    private final String description;

    public Movie(String id, int nVotes, double rating, String originalTitle, String primaryTitle, String description) {
        this.id = id;
        this.nVotes = nVotes;
        this.rating = rating;
        this.originalTitle = originalTitle;
        this.primaryTitle = primaryTitle;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public int getnVotes() {
        return nVotes;
    }

    public double getRating() {
        return rating;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public String getDescription() {
        return description;
    }
}
