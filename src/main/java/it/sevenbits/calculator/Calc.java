package it.sevenbits.calculator;

import it.sevenbits.calculator.nodes.Node;
import it.sevenbits.calculator.parser.ParserException;
import it.sevenbits.calculator.parser.ParserImpl;
import it.sevenbits.calculator.stack.Stack;
import it.sevenbits.calculator.tokenizer.Tokenizer;

import java.util.List;
import java.util.function.Supplier;

/**
 * Reverse Polish notation calculator.
 * <a href='https://en.wikipedia.org/wiki/Reverse_Polish_notation'>wiki</a>
 */
public class Calc {
    private Tokenizer tokenizer;
    private ParserImpl parser;
    private Supplier<Stack> stackBuilder;

    public Calc(Tokenizer scanner, ParserImpl parser, Supplier<Stack> stackBuilder) {
        this.tokenizer = scanner;
        this.parser = parser;
        this.stackBuilder = stackBuilder;
    }

    public float eval(String expression) throws ParserException {
        List<String> tokens = tokenizer.tokenize(expression);
        List<Node> nodes = parser.parse(tokens);
        if (nodes == null || nodes.isEmpty()) return 0f;
        Stack stack = stackBuilder.get();
        for (Node node : nodes) {
            node.act(stack);
        }

        return stack.pop();
    }
}
