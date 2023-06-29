package dev.patika.week5assignment.exception;

public class ExpeditionException extends RuntimeException {
    public ExpeditionException(String message) {
        super(message);
    }

    public ExpeditionException(String message, Throwable cause) {
        super(message, cause);
    }
}
