package it.sevenbits.calculator;

import java.util.List;

public interface Tokenizer {
    List<Token> tokenize(final List<String> atoms) throws TokenizerException;
}
