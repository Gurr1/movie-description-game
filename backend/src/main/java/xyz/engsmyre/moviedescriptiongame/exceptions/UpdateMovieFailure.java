package xyz.engsmyre.moviedescriptiongame.exceptions;

import org.springframework.http.HttpStatus;

public class UpdateMovieFailure extends CustomException {
    public UpdateMovieFailure(HttpStatus status, String reason) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "COULD_NOT_UPDATE_MOVIE_CACHE");    // TODO fix error code
    }
}
