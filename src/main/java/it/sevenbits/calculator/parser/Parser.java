package it.sevenbits.calculator.parser;

import java.util.List;

public interface Parser {
    List<String> parse(final String expression);
}
