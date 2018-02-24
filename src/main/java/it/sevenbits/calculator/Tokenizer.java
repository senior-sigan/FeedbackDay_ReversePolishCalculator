package it.sevenbits.calculator;

import java.util.List;

public interface Tokenizer {
    List<String> tokenize(String expression);
}
