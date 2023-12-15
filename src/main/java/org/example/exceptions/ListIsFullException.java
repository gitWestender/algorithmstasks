package org.example.exceptions;

public class ListIsFullException extends RuntimeException{
    public ListIsFullException() {
    }

    public ListIsFullException(String message) {
        super(message);
    }

    public ListIsFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ListIsFullException(Throwable cause) {
        super(cause);
    }

    public ListIsFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
