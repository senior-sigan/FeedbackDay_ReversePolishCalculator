package it.sevenbits.calculator.core.parser;

import it.sevenbits.calculator.core.nodes.FloatNode;
import it.sevenbits.calculator.core.nodes.Node;
import it.sevenbits.calculator.core.nodes.OperationNode;
import it.sevenbits.calculator.core.operations.Operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParserImpl implements Parser {
    private final Map<String, Operation> operations;

    public ParserImpl(final List<Operation> operations) {
        this.operations = new HashMap<>();
        operations.forEach(operation ->
                this.operations.put(operation.getSymbol(), operation));
    }

    @Override
    public List<Node> parse(List<String> tokens) throws ParserException {
        List<Node> nodes = new ArrayList<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                nodes.add(new FloatNode(Float.parseFloat(token)));
            } else if (operations.containsKey(token)) {
                nodes.add(new OperationNode(operations.get(token)));
            } else {
                throw new ParserException(String.format("Token %s is not supported", token));
            }
        }

        return nodes;
    }

    private boolean isNumber(String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
