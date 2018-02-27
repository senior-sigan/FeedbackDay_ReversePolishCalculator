package it.sevenbits.calculator.tokenizer;

import java.util.List;

/**
 * Lexical analysis.
 * <p>
 * Read a sequence of characters and split them into tokens.
 * A token(lexeme) is a sequence of characters that matches the pattern
 * for a token and is identified by the lexical analyzer
 * as an instance of that token.
 */
public interface Tokenizer {
    List<String> tokenize(final String expression);
}
