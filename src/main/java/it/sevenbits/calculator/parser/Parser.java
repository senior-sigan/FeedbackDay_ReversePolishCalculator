package it.sevenbits.calculator.parser;

import it.sevenbits.calculator.nodes.Node;

import java.util.List;

/**
 * Syntactic analysis.
 * <p>
 * They say, a parser assembles tokens into abstract syntax tree.
 * Here we have simplified case, but the parser
 * converts each token into {@link Node}.
 */
public interface Parser {
    List<Node> parse(final List<String> tokens) throws ParserException;
}
