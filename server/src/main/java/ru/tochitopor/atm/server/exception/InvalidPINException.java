package ru.tochitopor.atm.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidPINException  extends RuntimeException {
    public InvalidPINException() {
    }

    public InvalidPINException(String message) {
        super(message);
    }

    public InvalidPINException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPINException(Throwable cause) {
        super(cause);
    }

    public InvalidPINException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
