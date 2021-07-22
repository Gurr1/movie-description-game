package xyz.engsmyre.moviedescriptiongame.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CustomException extends ResponseStatusException {
    public CustomException(HttpStatus status, String reason) {
        super(status, reason);
    }

    @Override
    public Throwable getMostSpecificCause() {
        return null;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
