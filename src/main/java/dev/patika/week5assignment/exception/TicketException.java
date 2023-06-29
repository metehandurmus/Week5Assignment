package dev.patika.week5assignment.exception;

public class TicketException extends RuntimeException {
    public TicketException(String message) {
        super(message);
    }

    public TicketException(String message, Throwable cause) {
        super(message, cause);
    }
}
