package it.sevenbits.calculator.tokenizer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SpaceTokenizer implements Tokenizer {
    @Override
    public List<String> tokenize(final String expression) {
        if (expression == null || expression.trim().isEmpty()) return Collections.emptyList();
        String[] tokens = expression.trim().split(" ");
        return Arrays.stream(tokens).map(String::trim).collect(Collectors.toList());
    }
}
