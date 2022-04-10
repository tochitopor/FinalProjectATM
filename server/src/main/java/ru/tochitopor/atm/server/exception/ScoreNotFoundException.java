package ru.tochitopor.atm.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ScoreNotFoundException extends RuntimeException {
    public ScoreNotFoundException() {
    }

    public ScoreNotFoundException(String message) {
        super(message);
    }

    public ScoreNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScoreNotFoundException(Throwable cause) {
        super(cause);
    }

    public ScoreNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
