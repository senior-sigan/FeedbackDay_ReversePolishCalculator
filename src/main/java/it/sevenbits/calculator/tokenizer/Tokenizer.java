package it.sevenbits.calculator.tokenizer;

import it.sevenbits.calculator.tokens.Token;

import java.util.List;

public interface Tokenizer {
    List<Token> tokenize(final List<String> atoms) throws TokenizerException;
}
