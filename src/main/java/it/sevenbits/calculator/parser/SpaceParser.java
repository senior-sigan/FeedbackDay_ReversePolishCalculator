package it.sevenbits.calculator.parser;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SpaceParser implements Parser {
    @Override
    public List<String> parse(final String expression) {
        if (expression == null || expression.trim().isEmpty()) return Collections.emptyList();
        String[] words = expression.trim().split(" ");
        return Arrays.asList(words);
    }
}
