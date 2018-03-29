package it.sevenbits.calculator;

public class StackException extends Exception {
    public StackException() {
    }

    public StackException(final String message) {
        super(message);
    }

    public StackException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public StackException(final Throwable cause) {
        super(cause);
    }
}
