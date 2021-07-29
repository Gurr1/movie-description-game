package xyz.engsmyre.moviedescriptiongame.tmdb.exception;

import org.springframework.http.HttpStatus;
import xyz.engsmyre.moviedescriptiongame.exceptions.CustomException;

public class TmdbCommunicationFailedException extends CustomException {
    public TmdbCommunicationFailedException(String reason) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "COULD_NOT_UPDATE_MOVIE_CACHE");    // TODO fix error code
        System.out.println("communication with TMDB failed with underlying reason \n" + reason);    // TODO LOGGING
    }

    public TmdbCommunicationFailedException(Exception e) {
        this(e.getMessage());
        System.out.println(e);
    }
}
