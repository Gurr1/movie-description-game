package xyz.engsmyre.moviedescriptiongame.domain;

public class Title {

    public enum Type {
        MOVIE,
        SERIES,
        SHORT,
        EPISODE,
        UNKNOWN;

    }
    private final String id;
    private final String originalTitle;
    private final String primaryTitle;
    private final Type titleType;

    public Title(String id, String originalTitle, String primaryTitle, String titleType) {
        this.id = id;
        this.originalTitle = originalTitle;
        this.primaryTitle = primaryTitle;
        this.titleType = getType(titleType);
    }

    private Type getType(String typeString) {
        switch (typeString) {
            case "short":
                return Type.SHORT;
            case "movie":
            case "tvMovie":
                return Type.MOVIE;
            case "tvSeries":
                return Type.SERIES;
            case "tvEpisode":
                return Type.EPISODE;
            default:
                return Type.UNKNOWN;

        }
    }

    public String getId() {
        return id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public Type getTitleType() {
        return titleType;
    }
}
