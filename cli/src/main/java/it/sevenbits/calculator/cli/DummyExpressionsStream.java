package it.sevenbits.calculator.cli;

import java.util.function.Consumer;

public class DummyExpressionsStream implements ExpressionsStream {
    public void forEach(Consumer<? super String> expression) {
        expression.accept("15 7 1 1 + - / 3 * 2 1 1 + + -");
        expression.accept("5 1 2 + 4 * + 3 -");
    }
}
