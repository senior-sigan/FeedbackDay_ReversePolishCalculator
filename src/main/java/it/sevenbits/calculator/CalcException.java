package it.sevenbits.calculator;

public class CalcException extends Exception {
    public CalcException() {
    }

    public CalcException(final String message) {
        super(message);
    }

    public CalcException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CalcException(final Throwable cause) {
        super(cause);
    }
}
