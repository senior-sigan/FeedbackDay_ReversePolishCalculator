package it.sevenbits.calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SpaceTokenizer implements Tokenizer {
    @Override
    public List<String> tokenize(final String expression) {
        if (expression == null || expression.trim().isEmpty()) return Collections.emptyList();
        String[] tokens = expression.trim().split(" ");
        return Arrays.asList(tokens);
    }
}
