package xyz.engsmyre.moviedescriptiongame.domain;

public class Rating {

    private final String id;
    private final double rating;
    private final int nVotes;

    public Rating(String id, double rating, int nVotes) {
        this.id = id;
        this.rating = rating;
        this.nVotes = nVotes;
    }

    public String getId() {
        return id;
    }

    public double getRating() {
        return rating;
    }

    public int getnVotes() {
        return nVotes;
    }
}
