package it.sevenbits.calculator.core;

import it.sevenbits.calculator.core.nodes.Node;
import it.sevenbits.calculator.core.parser.Parser;
import it.sevenbits.calculator.core.parser.ParserException;
import it.sevenbits.calculator.core.stack.Stack;
import it.sevenbits.calculator.core.tokenizer.Tokenizer;

import java.util.List;
import java.util.function.Supplier;

/**
 * Reverse Polish notation calculator.
 * <a href='https://en.wikipedia.org/wiki/Reverse_Polish_notation'>wiki</a>
 */
public class Calc {
    private Tokenizer tokenizer;
    private Parser parser;
    private Supplier<Stack> stackBuilder;

    public Calc(Tokenizer scanner, Parser parser, Supplier<Stack> stackBuilder) {
        this.tokenizer = scanner;
        this.parser = parser;
        this.stackBuilder = stackBuilder;
    }

    public Double eval(String expression) throws ParserException {
        List<String> tokens = tokenizer.tokenize(expression);
        List<Node> nodes = parser.parse(tokens);
        if (nodes == null || nodes.isEmpty()) return 0.0;
        Stack stack = stackBuilder.get();
        for (Node node : nodes) {
            node.act(stack);
        }

        return stack.pop();
    }
}
