package it.sevenbits.calculator;

import java.util.List;
import java.util.function.Supplier;

/**
 * Reverse Polish notation calculator.
 * <a href='https://en.wikipedia.org/wiki/Reverse_Polish_notation'>wiki</a>
 */
public class Calc {
    private Parser parser;
    private TokenizerImpl tokenizer;
    private Supplier<Stack> stackBuilder;

    public Calc(Parser parser, TokenizerImpl tokenizer, Supplier<Stack> stackBuilder) {
        this.parser = parser;
        this.tokenizer = tokenizer;
        this.stackBuilder = stackBuilder;
    }

    public float eval(String expression) throws TokenizerException {
        List<String> atoms = parser.parse(expression);
        List<Token> tokens = tokenizer.tokenize(atoms);
        if (tokens == null || tokens.isEmpty()) return 0f;
        Stack stack = stackBuilder.get();
        for (Token token : tokens) {
            token.act(stack);
        }

        return stack.pop();
    }
}
