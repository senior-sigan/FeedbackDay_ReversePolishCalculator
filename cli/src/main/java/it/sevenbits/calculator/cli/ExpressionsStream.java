package it.sevenbits.calculator.cli;

import java.util.function.Consumer;

public interface ExpressionsStream {
    void forEach(Consumer<? super String> expression);
}
