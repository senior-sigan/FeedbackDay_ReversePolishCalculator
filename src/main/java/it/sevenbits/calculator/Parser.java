package it.sevenbits.calculator;

import java.util.List;

public interface Parser {
    List<String> parse(final String expression);
}
